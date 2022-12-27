package com.indodana.learnandroid.ui.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.indodana.learnandroid.adapter.SampleAdapter
import com.indodana.learnandroid.common.annotation.Numbered
import com.indodana.learnandroid.contract.AnotherContract
import com.indodana.learnandroid.databinding.ActivityAnotherBinding
import com.indodana.learnandroid.delegate.viewBinding
import com.indodana.learnandroid.model.UnscopedDependency
import com.indodana.learnandroid.presenter.AnotherPresenter
import com.indodana.learnandroid.repository.response.MovieResponse
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject
import javax.inject.Named

private const val TAG = "Dagger.AnotherActivity"

class AnotherActivity : DaggerAppCompatActivity(), AnotherContract.View {

    private val binding by viewBinding(ActivityAnotherBinding::inflate)
    private val adapter by lazy { SampleAdapter() }

    @Inject
    lateinit var presenter: AnotherPresenter

//    @Inject
//    @Named("AnotherModuleText")
//    lateinit var anotherModuleString: String
//
//    @Inject
//    @Numbered(1)
//    lateinit var otherAnotherModuleString: String
//
//    @Inject
//    @Named("SampleFragmentText")
//    lateinit var sampleFragmentText: String
//
//    @Inject
//    lateinit var unscopedDependency: UnscopedDependency
//
//    @Inject
//    lateinit var unscopedDependencyA: UnscopedDependency

    //    @Inject lateinit var movieRemoteDataSource: MovieRemoteDataSource
    //    @Inject lateinit var repository: MovieRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //        movieRemoteDataSource = MovieRemoteDataSource()
        //        repository = MovieRepository(movieRemoteDataSource)
        //
        //        presenter = AnotherPresenter(this, repository)

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        presenter.loadMovies()

//        Log.e(TAG, "onCreate: $anotherModuleString")
//        Log.e(TAG, "onCreate: $otherAnotherModuleString")
//        Log.e(TAG, "onCreate: $sampleFragmentText")

        setContentView(binding.root)
    }

    override fun showMovies(movies: List<MovieResponse>) {
        adapter.setDataSet(movies)
    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun showProgressBar() {
        binding.progressBar.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        binding.progressBar.visibility = View.GONE
    }
}