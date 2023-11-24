package com.example.myapplication.framework.adapters.viewholders

import android.content.Context
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.data.network.model.Country
import com.example.myapplication.databinding.ItemBinding

class ViewHolder(private val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Country){
        binding.Country.text = item.country
        binding.Total.text = item.cases.total.toString()
        binding.New.text = item.cases.new.toString()
    }
}