package com.indodana.learnandroid.presenter

import com.indodana.learnandroid.contract.AnotherContract
import com.indodana.learnandroid.repository.MovieRepository

class AnotherPresenter(
    private var view: AnotherContract.View?,
    private val repository: MovieRepository
) : AnotherContract.Presenter {
    override fun loadMovies() {
        val result = repository.getMovies()

        view?.showMovies(result)
    }

    override fun onDestroy() {
        view = null
    }
}