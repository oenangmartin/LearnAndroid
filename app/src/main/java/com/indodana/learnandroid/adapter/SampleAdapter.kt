package com.indodana.learnandroid.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.indodana.learnandroid.databinding.ItemSampleBinding
import com.indodana.learnandroid.model.SampleDataModel

class SampleAdapter : RecyclerView.Adapter<SampleAdapter.SampleDataViewHolder>() {

    private val dataSet: MutableList<SampleDataModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SampleDataViewHolder {
        Log.e("LA.MainActivity", "onCreateViewHolder")
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

    fun setDataSet(data: List<SampleDataModel>) {
        dataSet.addAll(data)
    }

    class SampleDataViewHolder(private val viewBinding: ItemSampleBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(data: SampleDataModel) {
            viewBinding.textView.text = data.primaryText
            viewBinding.textView.visibility = if (data.isVisible) View.VISIBLE else View.GONE
        }
    }
}