package com.indodana.learnandroid.data.api

import com.indodana.learnandroid.repository.response.MovieResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {
    @GET("/posts")
    fun getPosts(): Call<List<MovieResponse>>
}