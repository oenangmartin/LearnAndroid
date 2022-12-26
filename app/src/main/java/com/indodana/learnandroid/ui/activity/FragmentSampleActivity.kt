package com.indodana.learnandroid.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.indodana.learnandroid.R
import com.indodana.learnandroid.databinding.ActivityFragmentBinding
import com.indodana.learnandroid.delegate.viewBinding
import com.indodana.learnandroid.ui.fragment.SampleFragment

class FragmentSampleActivity : AppCompatActivity() {
    private val binding by viewBinding(ActivityFragmentBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        showFragment()
    }

    private fun showFragment() {
        val fragment = SampleFragment.newInstance()
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment, "TAG")
            .commit()
    }
}