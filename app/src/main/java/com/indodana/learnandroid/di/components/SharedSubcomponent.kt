package com.indodana.learnandroid.di.components

import com.indodana.learnandroid.ui.activity.AnotherActivity
import com.indodana.learnandroid.ui.activity.MainActivity
import dagger.Subcomponent

@Subcomponent
interface SharedSubcomponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): SharedSubcomponent
    }

    // Classes that can be injected by this Component
    fun inject(activity: MainActivity)
    fun inject(activity: AnotherActivity)
}
