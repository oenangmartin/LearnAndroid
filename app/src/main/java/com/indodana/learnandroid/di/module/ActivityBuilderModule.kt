package com.indodana.learnandroid.di.module

import com.indodana.learnandroid.ui.activity.AnotherActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {
    @ContributesAndroidInjector(modules = [AnotherModule::class])
    abstract fun bindAnotherActivity(): AnotherActivity
}