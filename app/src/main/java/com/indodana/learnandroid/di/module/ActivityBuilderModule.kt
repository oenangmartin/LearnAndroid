package com.indodana.learnandroid.di.module

import com.indodana.learnandroid.common.annotation.ActivityScope
import com.indodana.learnandroid.ui.activity.AnotherActivity
import com.indodana.learnandroid.ui.activity.MainActivity
import com.indodana.learnandroid.ui.fragment.SampleFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [AnotherModule::class])
    abstract fun bindAnotherActivity(): AnotherActivity

    @ContributesAndroidInjector(modules = [SampleFragmentModule::class])
    abstract fun bindSampleFragment(): SampleFragment
}