package com.documentary.domain

import com.documentary.base.InvokeError
import com.documentary.base.InvokeStarted
import com.documentary.base.InvokeStatus
import com.documentary.base.InvokeSuccess
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
    operator fun invoke(params: Params): Flow<ReturnType> {
        return flow {
            emit(doWork(params))
        }
    }

    protected abstract suspend fun doWork(params: Params): ReturnType
}

abstract class SuspendingWorkInteractor<Params : Any, ReturnType> : SubjectInteractor<Params, ReturnType>() {
    override fun createObservable(params: Params): Flow<ReturnType> = flow {
        emit(doWork(params))
    }

    abstract suspend fun doWork(params: Params): ReturnType
}

abstract class SubjectInteractor<Params : Any, ReturnType> {
    private val paramState = MutableStateFlow<Params?>(null)

    operator fun invoke(params: Params) {
        paramState.value = params
    }

    protected abstract fun createObservable(params: Params): Flow<ReturnType>

    fun observe(): Flow<ReturnType> = paramState.filterNotNull().flatMapLatest { createObservable(it) }
}

operator fun Interactor<Unit>.invoke() = invoke(Unit)
operator fun <T> SubjectInteractor<Unit, T>.invoke() = invoke(Unit)

