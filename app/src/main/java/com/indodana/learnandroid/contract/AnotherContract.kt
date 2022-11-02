package com.indodana.learnandroid.contract

import com.indodana.learnandroid.repository.response.MovieResponse

interface AnotherContract {
    interface View {
        fun showMovies(movies: List<MovieResponse>)
    }

    interface Presenter {
        fun loadMovies()
        fun onDestroy()
    }
}