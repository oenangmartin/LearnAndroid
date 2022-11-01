package com.indodana.learnandroid

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.indodana.learnandroid.databinding.ActivityMainLinearBinding
import com.indodana.learnandroid.delegate.viewBinding

class MainActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "LA.MainActivity"
    }

    private val binding by viewBinding(ActivityMainLinearBinding::inflate)
    private var currentState: String? = null

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
        setContentView(binding.root)
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
        Log.e(TAG, "onDestroy MainActivity")
    }
}