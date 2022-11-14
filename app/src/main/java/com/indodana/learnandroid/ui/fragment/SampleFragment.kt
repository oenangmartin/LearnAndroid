package com.indodana.learnandroid.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.indodana.learnandroid.R
import com.indodana.learnandroid.databinding.FragmentSampleBinding
import com.indodana.learnandroid.delegate.viewBinding

class SampleFragment : Fragment() {
    private val binding by viewBinding(FragmentSampleBinding::bind)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sample, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        fun newInstance(): SampleFragment {
            return SampleFragment()
        }
    }
}