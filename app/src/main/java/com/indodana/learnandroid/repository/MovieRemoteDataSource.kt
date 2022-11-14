package com.indodana.learnandroid.repository

import com.indodana.learnandroid.repository.response.MovieResponse
import javax.inject.Inject

class MovieRemoteDataSource
@Inject constructor()  : MovieDataSource {
    override fun getMovies(): List<MovieResponse> {
        return listOf(
            MovieResponse(
                "Avenger",
                "2022-01-01"
            ),
            MovieResponse(
                "Avatar",
                "2021-01-01"
            ),
            MovieResponse(
                "Cars",
                "2019-01-01"
            ),
            MovieResponse(
                "Pirates of The Caribbean",
                "2020-01-01"
            )
        )
    }
}