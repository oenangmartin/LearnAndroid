package com.indodana.learnandroid.di.module

import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class SampleFragmentModule {
    @Provides
    @Named("SampleFragmentText")
    fun provideSharedString(): String = "String from Sample Fragment Module"
}