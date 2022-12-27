package com.indodana.learnandroid.presenter

import android.util.Log
import com.indodana.learnandroid.contract.AnotherContract
import com.indodana.learnandroid.repository.MovieRepository
import com.indodana.learnandroid.repository.response.MovieResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


class AnotherPresenter
@Inject constructor(
    private var view: AnotherContract.View?,
    private val repository: MovieRepository
) : AnotherContract.Presenter {
    override fun loadMovies() {
        view?.showProgressBar()

        val result = repository.getMovies()

        result.enqueue(object : Callback<List<MovieResponse>> {
            override fun onResponse(
                call: Call<List<MovieResponse>>,
                response: Response<List<MovieResponse>>
            ) {
                view?.hideProgressBar()

                if (response.isSuccessful) {
                    val data = response.body() ?: emptyList()
                    view?.showMovies(data)
                }
            }

            override fun onFailure(call: Call<List<MovieResponse>>, t: Throwable) {
                view?.hideProgressBar()
                view?.showError(t.message.orEmpty())
            }

        })
    }

    override fun onDestroy() {
        view = null
    }
}