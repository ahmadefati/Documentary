package com.documentary.view

import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import timber.log.Timber
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * A lazy property that gets cleaned up when the fragment is destroyed.
 *
 * Accessing this variable in a destroyed fragment will throw NPE.
 */
class AutoClearedValue<T : Any>(val fragment: Fragment, beforeNullCallback: (() -> Unit)?) :
    ReadWriteProperty<Fragment, T> {
    private var _value: T? = null

    init {
        fragment.lifecycle.addObserver(object : DefaultLifecycleObserver {
            val viewLifecycleOwnerLiveDataObserver =
                Observer<LifecycleOwner?> {
                    val viewLifecycleOwner = it ?: return@Observer

                    viewLifecycleOwner.lifecycle.addObserver(object : DefaultLifecycleObserver {
                        override fun onDestroy(owner: LifecycleOwner) {
                            beforeNullCallback?.invoke()
                            _value = null
                        }
                    })
                }

            override fun onCreate(owner: LifecycleOwner) {
                fragment.viewLifecycleOwnerLiveData.observeForever(
                    viewLifecycleOwnerLiveDataObserver
                )
            }

            override fun onDestroy(owner: LifecycleOwner) {
                fragment.viewLifecycleOwnerLiveData.removeObserver(
                    viewLifecycleOwnerLiveDataObserver
                )
            }
        })
    }

    // if exception thrown changes, change the value in exceptionHandler in baseFragment
    override fun getValue(thisRef: Fragment, property: KProperty<*>): T {
        return _value ?: throw IllegalStateException(EXCEPTION_ON_NULL_ACCESS)
    }

    override fun setValue(thisRef: Fragment, property: KProperty<*>, value: T) {
        _value = value
    }

    companion object {
        const val EXCEPTION_ON_NULL_ACCESS =
            "should never call auto-cleared-value get when it might not be available"
    }
}

/**
 * Creates an [AutoClearedValue] associated with this fragment.
 */
fun <T : Any> Fragment.autoCleared(beforeNullCallback: (() -> Unit)? = null) =
    AutoClearedValue<T>(this, beforeNullCallback)

/**
 * Ignore Exception thrown in AutoClearedValue for access to after it becomes null
 * */
fun CoroutineScope.launchWithErrorHandler(
    context: CoroutineContext = EmptyCoroutineContext,
    block: suspend CoroutineScope.() -> Unit
) = run {
    val errorHandler = CoroutineExceptionHandler { _, error ->
        when (error) {
            is IllegalStateException -> {
                if (error.message != AutoClearedValue.EXCEPTION_ON_NULL_ACCESS) {
                    throw error
                } else {
                    Timber.tag("AutoClearedValueTAG")
                        .d("Tried to access value after fragment view is destroyed")
                }
            }
            else -> throw error
        }
    }


    launch(
        context = context + errorHandler,
        block = block
    )
}