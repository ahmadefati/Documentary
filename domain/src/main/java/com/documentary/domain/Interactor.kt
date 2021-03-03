package com.documentary.domain

import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.documentary.base.InvokeError
import com.documentary.base.InvokeStarted
import com.documentary.base.InvokeStatus
import com.documentary.base.InvokeSuccess
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.withTimeout
import java.util.concurrent.TimeUnit


abstract class Interactor<in Params> {
    operator fun invoke(params: Params, timeoutMs: Long = defaultTimeoutMs): Flow<InvokeStatus> {
        return flow {
            withTimeout(timeoutMs) {
                emit(InvokeStarted)
                doWork(params)
                emit(InvokeSuccess)
            }
        }.catch { t ->
            emit(InvokeError(t))
        }
    }

    suspend fun executeSync(params: Params) = doWork(params)

    protected abstract suspend fun doWork(params: Params)

    companion object {
        private val defaultTimeoutMs = TimeUnit.MINUTES.toMillis(5)
    }
}

abstract class ResultInteractor<in Params, ReturnType> {
    operator fun invoke(params: Params): Flow<ReturnType> = flow {
        emit(doWork(params))
    }

    suspend fun executeSync(params: Params): ReturnType = doWork(params)

    protected abstract suspend fun doWork(params: Params): ReturnType
}

abstract class SuspendingWorkInteractor<Params : Any, T> : SubjectInteractor<Params, T>() {
    override fun createObservable(params: Params): Flow<T> = flow {
        emit(doWork(params))
    }

    abstract suspend fun doWork(params: Params): T
}

abstract class PagingInteractor<Params : PagingInteractor.Parameters<T>, T : Any> :
    SubjectInteractor<Params, PagingData<T>>() {
    interface Parameters<T : Any> {
        val pagingConfig: PagingConfig
    }
}

abstract class SubjectInteractor<Params : Any, T> {
    // Ideally this would be buffer = 0, since we use flatMapLatest below, BUT invoke is not
    // suspending. This means that we can't suspend while flatMapLatest cancels any
    // existing flows. The buffer of 1 means that we can use tryEmit() and buffer the value
    // instead, resulting in mostly the same result.
    private val paramState = MutableSharedFlow<Params>(
        replay = 1,
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )

    operator fun invoke(params: Params) {
        paramState.tryEmit(params)
    }

    protected abstract fun createObservable(params: Params): Flow<T>

    fun observe(): Flow<T> = paramState.flatMapLatest { createObservable(it) }
}