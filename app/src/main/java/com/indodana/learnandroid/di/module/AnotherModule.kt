package com.indodana.learnandroid.di.module

import com.indodana.learnandroid.common.annotation.ActivityScope
import com.indodana.learnandroid.common.annotation.Numbered
import com.indodana.learnandroid.contract.AnotherContract
import com.indodana.learnandroid.model.UnscopedDependency
import com.indodana.learnandroid.ui.activity.AnotherActivity
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module(includes = [SampleFragmentModule::class])
class AnotherModule {
//    @Provides
//    fun provideMovieRemoteDataSource(): MovieRemoteDataSource = MovieRemoteDataSource()

//    @Provides
//    fun provideRepository(movieRemoteDataSource: MovieRemoteDataSource): MovieRepository =
//        MovieRepository(movieRemoteDataSource)

//    @Provides
//    fun providePresenter(
//        view: AnotherContract.View,
//        repository: MovieRepository
//    ): AnotherPresenter = AnotherPresenter(view, repository)

    @Provides
    fun provideView(anotherActivity: AnotherActivity): AnotherContract.View = anotherActivity

    @Provides
    @Named("AnotherModuleText")
    fun provideAnotherModuleText(): String = "String from Another Module"

    @Provides
    @Numbered(1)
    fun provideOtherAnotherModuleText(): String = "Another string from another module"

    @Provides
    @ActivityScope
    fun provideADependency(): UnscopedDependency = UnscopedDependency()
}