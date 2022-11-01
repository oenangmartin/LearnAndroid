package com.indodana.learnandroid.delegate

import android.os.Looper
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class ViewBindingActivityDelegate<T : ViewBinding>(
    private val activity: AppCompatActivity,
    private val bindingInflater: (LayoutInflater) -> T
) : ReadOnlyProperty<AppCompatActivity, T>, LifecycleObserver {

    private var binding: T? = null

    init {
        activity.lifecycle.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        if (binding == null) {
            binding = bindingInflater(activity.layoutInflater)
        }

        with (activity) {
            setContentView(binding?.root!!)
            lifecycle.removeObserver(this@ViewBindingActivityDelegate)
        }
    }

    override fun getValue(thisRef: AppCompatActivity, property: KProperty<*>): T {
        if (binding == null) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                throw IllegalThreadStateException("This cannot be called from other threads. " +
                        "It should be on the main thread only")
            }

            binding = bindingInflater(thisRef.layoutInflater)
        }

        return binding!!
    }
}

inline fun <reified T : ViewBinding> AppCompatActivity.activityViewBinding(
    noinline bindingInflater: (LayoutInflater) -> T) = ViewBindingActivityDelegate(this, bindingInflater)