package com.example.myapplication.framework.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.data.network.model.Country
import com.example.myapplication.databinding.ItemBinding
import com.example.myapplication.framework.adapters.viewholders.ViewHolder

/**
 * Adapter class for RecyclerView
 */
class Adapter : RecyclerView.Adapter<ViewHolder>() {
    // Data source for the adapter
    var data: ArrayList<Country> = ArrayList()
    lateinit var context: Context

    /**
     * Constructor to initialize the adapter with data and context
     *
     * @param basicData List of countries
     * @param context context
     */
    fun Adapter(basicData: List<Country>, context: Context) {
        this.data = basicData as ArrayList<Country>
        this.context = context
    }

    /**
     * Binds data to the ViewHolder
     *
     * @param holder ViewHolder
     * @param position Data position
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    /**
     * Creates a new ViewHolder
     *
     * @param parent
     * @param viewType
     *
     * @return ViewHolder
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Inflate the layout for each item using data binding
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    /**
     * Returns the total number of items in the data set held by the adapter\
     *
     * @return data.size
     */
    override fun getItemCount(): Int {
        return data.size
    }
}
