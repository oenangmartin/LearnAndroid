package com.indodana.learnandroid.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.indodana.learnandroid.R
import com.indodana.learnandroid.databinding.FragmentSampleBinding
import com.indodana.learnandroid.delegate.viewBinding
import dagger.android.support.DaggerFragment
import javax.inject.Inject
import javax.inject.Named

class SampleFragment : DaggerFragment() {
    private val binding by viewBinding(FragmentSampleBinding::bind)

    @Inject
    @Named("SampleFragmentText")
    lateinit var sampleString: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sample, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.additionalText.text = sampleString
    }

    companion object {
        fun newInstance(): SampleFragment {
            return SampleFragment()
        }
    }
}