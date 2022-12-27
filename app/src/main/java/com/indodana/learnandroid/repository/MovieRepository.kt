package com.indodana.learnandroid.repository

import com.indodana.learnandroid.repository.response.MovieResponse
import retrofit2.Call
import javax.inject.Inject

class MovieRepository
@Inject constructor(
    private val movieRemoteDataSource: MovieRemoteDataSource
) : MovieDataSource {
    override fun getMovies(): Call<List<MovieResponse>> {
        return movieRemoteDataSource.getMovies()
    }
}