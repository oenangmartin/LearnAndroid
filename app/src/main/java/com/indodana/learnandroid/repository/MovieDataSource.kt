package com.indodana.learnandroid.repository

import com.indodana.learnandroid.repository.response.MovieResponse

interface MovieDataSource {
    fun getMovies(): List<MovieResponse>
}