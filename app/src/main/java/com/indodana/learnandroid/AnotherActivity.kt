package com.indodana.learnandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.indodana.learnandroid.adapter.SampleAdapter
import com.indodana.learnandroid.databinding.ActivityAnotherBinding
import com.indodana.learnandroid.delegate.viewBinding
import com.indodana.learnandroid.model.SampleModelGenerator

class AnotherActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityAnotherBinding::inflate)
    private val adapter by lazy { SampleAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        adapter.setDataSet(SampleModelGenerator.generateSampleModel())

        setContentView(binding.root)
    }
}