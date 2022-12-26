package com.indodana.learnandroid.model

import android.util.Log

private const val TAG = "Dagger.Unscoped"

class UnscopedDependency() {
    init {
        Log.e(TAG, "UnscopedDependency constructor invoked")
    }
}

class ScopedDependency() {
    init {
        Log.e(TAG, "ScopedDependency constructor invoked")
    }
}