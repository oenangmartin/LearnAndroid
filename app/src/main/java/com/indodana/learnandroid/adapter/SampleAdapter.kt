package com.indodana.learnandroid.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.indodana.learnandroid.databinding.ItemSampleBinding
import com.indodana.learnandroid.repository.response.MovieResponse

class SampleAdapter : RecyclerView.Adapter<SampleAdapter.SampleDataViewHolder>() {

    private val dataSet: MutableList<MovieResponse> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SampleDataViewHolder {
        return SampleDataViewHolder(
            ItemSampleBinding.inflate(
                LayoutInflater.from(parent.context),
                null,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SampleDataViewHolder, position: Int) {
        Log.e("LA.MainActivity", "onBindViewHolder $position")
        holder.bind(dataSet[position])
    }

    override fun getItemCount(): Int = dataSet.size

    fun setDataSet(data: List<MovieResponse>) {
        val lastPosition = dataSet.size
        dataSet.addAll(lastPosition, data)
        notifyItemRangeInserted(lastPosition, dataSet.size)
    }

    class SampleDataViewHolder(private val viewBinding: ItemSampleBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(data: MovieResponse) {
            viewBinding.textView.text = data.title
            viewBinding.date.text = data.body
        }
    }
}