package com.indodana.learnandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.indodana.learnandroid.adapter.SampleAdapter
import com.indodana.learnandroid.contract.AnotherContract
import com.indodana.learnandroid.databinding.ActivityAnotherBinding
import com.indodana.learnandroid.delegate.viewBinding
import com.indodana.learnandroid.model.SampleModelGenerator
import com.indodana.learnandroid.presenter.AnotherPresenter
import com.indodana.learnandroid.repository.MovieRemoteDataSource
import com.indodana.learnandroid.repository.MovieRepository
import com.indodana.learnandroid.repository.response.MovieResponse

class AnotherActivity : AppCompatActivity(), AnotherContract.View {

    private val binding by viewBinding(ActivityAnotherBinding::inflate)
    private val adapter by lazy { SampleAdapter() }

    private lateinit var presenter: AnotherPresenter
    private lateinit var movieRemoteDataSource: MovieRemoteDataSource
    private lateinit var repository: MovieRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        movieRemoteDataSource = MovieRemoteDataSource()
        repository = MovieRepository(movieRemoteDataSource)

        presenter = AnotherPresenter(this, repository)

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        presenter.loadMovies()

        setContentView(binding.root)
    }

    override fun showMovies(movies: List<MovieResponse>) {
        adapter.setDataSet(movies)
    }
}