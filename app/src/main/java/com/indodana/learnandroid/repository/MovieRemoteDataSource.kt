package com.indodana.learnandroid.repository

import com.indodana.learnandroid.data.api.ApiInterface
import com.indodana.learnandroid.repository.response.MovieResponse
import retrofit2.Call
import javax.inject.Inject

class MovieRemoteDataSource
@Inject constructor(
    private val apiInterface: ApiInterface
)  : MovieDataSource {
    override fun getMovies(): Call<List<MovieResponse>> {
        return apiInterface.getPosts()
    }
}