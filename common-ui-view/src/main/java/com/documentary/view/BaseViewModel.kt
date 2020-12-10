package com.androiddevs.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.documentary.base.InvokeError
import com.documentary.base.InvokeStarted
import com.documentary.base.InvokeStatus
import com.documentary.base.InvokeSuccess
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlin.reflect.KProperty1

abstract class BaseViewModel<StateView>(
    initialState: StateView
) : ViewModel() {

    private val state = MutableStateFlow(initialState)
    private val stateMutex = Mutex()

    /**
     * Returns a snapshot of the current state.
     */
    fun currentState(): StateView = state.value

    val liveData: LiveData<StateView>
        get() = state.asLiveData()

    protected suspend fun <T> Flow<T>.collectAndSetState(reducer: StateView.(T) -> StateView) {
        return collect { item -> setState { reducer(item) } }
    }

    fun <A> selectObserve(prop1: KProperty1<StateView, A>): LiveData<A> {
        return selectSubscribe(prop1).asLiveData()
    }

    protected fun subscribe(block: (StateView) -> Unit) {
        viewModelScope.launch {
            state.collect { block(it) }
        }
    }

    protected fun <A> selectSubscribe(prop1: KProperty1<StateView, A>, block: (A) -> Unit) {
        viewModelScope.launch {
            selectSubscribe(prop1).collect { block(it) }
        }
    }

    private fun <A> selectSubscribe(prop1: KProperty1<StateView, A>): Flow<A> {
        return state.map { prop1.get(it) }.distinctUntilChanged()
    }

    protected suspend fun setState(reducer: StateView.() -> StateView) {
        stateMutex.withLock {
            state.value = reducer(state.value)
        }
    }

    protected fun CoroutineScope.launchSetState(reducer: StateView.() -> StateView) {
        launch { this@BaseViewModel.setState(reducer) }
    }

    protected suspend fun withState(block: (StateView) -> Unit) {
        stateMutex.withLock {
            block(state.value)
        }
    }

    protected fun CoroutineScope.withState(block: (StateView) -> Unit) {
        launch { this@BaseViewModel.withState(block) }
    }

    protected fun Flow<InvokeStatus>.watchStatus(
        onStarted: () -> Unit,
        onSuccess: () -> Unit,
        onError: (error: InvokeError) -> Unit
    ) = viewModelScope.launch {
        collect { status ->
            when (status) {
                InvokeStarted -> onStarted()
                InvokeSuccess -> onSuccess()
                is InvokeError -> onError(status)
            }
        }
    }

}