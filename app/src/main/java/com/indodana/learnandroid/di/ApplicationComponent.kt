package com.indodana.learnandroid.di

import com.indodana.learnandroid.LearnApplication
import com.indodana.learnandroid.di.module.ActivityBuilderModule
import com.indodana.learnandroid.di.module.AppModule
import com.indodana.learnandroid.di.module.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivityBuilderModule::class,
        AppModule::class,
        NetworkModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<LearnApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: LearnApplication): Builder

        fun build(): ApplicationComponent
    }
}