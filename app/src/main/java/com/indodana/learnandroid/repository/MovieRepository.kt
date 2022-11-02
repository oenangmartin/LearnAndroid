package com.indodana.learnandroid.repository

import com.indodana.learnandroid.repository.response.MovieResponse

class MovieRepository(
    private val movieRemoteDataSource: MovieRemoteDataSource
) : MovieDataSource {
    override fun getMovies(): List<MovieResponse> {
        return movieRemoteDataSource.getMovies()
    }
}