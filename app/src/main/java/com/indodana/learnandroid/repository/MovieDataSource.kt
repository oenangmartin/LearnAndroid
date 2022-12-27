package com.indodana.learnandroid.repository

import com.indodana.learnandroid.repository.response.MovieResponse
import retrofit2.Call

interface MovieDataSource {
    fun getMovies(): Call<List<MovieResponse>>
}