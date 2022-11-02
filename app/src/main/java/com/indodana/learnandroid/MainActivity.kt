package com.indodana.learnandroid

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide.init
import com.indodana.learnandroid.contract.MainContract
import com.indodana.learnandroid.databinding.ActivityMainLinearBinding
import com.indodana.learnandroid.delegate.viewBinding
import com.indodana.learnandroid.presenter.MainPresenter
import com.indodana.learnandroid.viewmodel.MainViewModel
import com.indodana.learnandroid.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity(), MainContract.View {
    companion object {
        private const val TAG = "LA.MainActivity"
    }

    private val binding by viewBinding(ActivityMainLinearBinding::inflate)
    private var currentState: String? = null

//    private lateinit var presenter: MainPresenter

    private val viewModel: MainViewModel by lazy { ViewModelProvider(this, MainViewModelFactory())[MainViewModel::class.java] }

    init {
        Log.e(TAG, "INITIALIZED")
        Log.e(TAG, currentState ?: "null")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e(TAG, "onCreate MainActivity")
        Log.e(TAG, "savedInstance onCreate: ${savedInstanceState?.getString("test")}")
        currentState = savedInstanceState?.getString("test") ?: "state"

        binding.container.setOnClickListener {
            currentState = "Navigate to another class"
            Intent(this@MainActivity, AnotherActivity::class.java).run {
                startActivity(this)
            }
        }

        binding.calculate.setOnClickListener {
            viewModel.sumNumber(
                binding.firstNumber.text.toString().toIntOrNull() ?: 0,
                binding.secondNumber.text.toString().toIntOrNull() ?: 0
            )
        }

        setContentView(binding.root)

        observeValue()
    }

    private fun observeValue() {
        viewModel.result.observe(this) { total ->
            binding.result.text = total.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.e(TAG, "saving currentState: $currentState")
        outState.putString("test", currentState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.e(TAG, "onRestoreInstanceState: ${savedInstanceState.getString("test")}")
        currentState = savedInstanceState.getString("test") ?: ""
    }

    override fun onStart() {
        super.onStart()
        Log.e(TAG, "onStart MainActivity")
    }

    override fun onResume() {
        super.onResume()
        Log.e(TAG, "onResume MainActivity")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e(TAG, "onRestart MainActivity")
    }

    override fun onPause() {
        super.onPause()
        Log.e(TAG, "onPause MainActivity")
    }

    override fun onStop() {
        super.onStop()
        Log.e(TAG, "onStop MainActivity")
    }

    override fun onDestroy() {
        super.onDestroy()
//        presenter.onDestroy()
        Log.e(TAG, "onDestroy MainActivity")
    }

    override fun showResult(result: Int) {
        binding.result.text = result.toString()
    }
}