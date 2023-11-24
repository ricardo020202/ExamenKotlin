package com.example.myapplication.framework.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.data.network.model.Country
import com.example.myapplication.databinding.ItemBinding
import com.example.myapplication.framework.adapters.viewholders.ViewHolder

class Adapter : RecyclerView.Adapter<ViewHolder>() {
    var data:ArrayList<Country> = ArrayList()
    lateinit var context: Context

    fun Adapter(basicData: List<Country>, context: Context){
        this.data = basicData as ArrayList<Country>
        this.context = context
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}