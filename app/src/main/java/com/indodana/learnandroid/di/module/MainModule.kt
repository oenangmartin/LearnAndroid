package com.indodana.learnandroid.di.module

import dagger.Module
import dagger.Provides

@Module
class MainModule {

    @Provides
    fun provideMainModuleText(): String = "String from Main Module"
}