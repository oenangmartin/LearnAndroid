package com.indodana.learnandroid.di.module

import com.indodana.learnandroid.contract.AnotherContract
import com.indodana.learnandroid.presenter.AnotherPresenter
import com.indodana.learnandroid.repository.MovieRepository
import com.indodana.learnandroid.ui.activity.AnotherActivity
import dagger.Module
import dagger.Provides

@Module
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
}