package com.example.myapplication.framework.adapters.viewholders

import android.content.Context
import android.content.res.Configuration
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.data.network.model.Country
import com.example.myapplication.databinding.ItemBinding
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry

class ViewHolder(private val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Country){
        binding.Country.text = item.country

        val barChart: BarChart = binding.barChart
        val totalEntries = mutableListOf<BarEntry>()
        val newEntries = mutableListOf<BarEntry>()

        totalEntries.add(BarEntry(0f, item.cases.total.toFloat()))
        newEntries.add(BarEntry(0f, item.cases.new.toFloat()))

        val isDarkMode = (binding.root.context.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_YES
        val labelTextColor = if (isDarkMode) {
            ContextCompat.getColor(binding.root.context, R.color.labelTextDark)
        } else {
            ContextCompat.getColor(binding.root.context, R.color.labelTextLight)
        }

        val totalDataSet = BarDataSet(totalEntries, "Total").apply {
            color = ContextCompat.getColor(binding.root.context, R.color.colortotal)
            valueTextColor = labelTextColor
        }
        val newDataSet = BarDataSet(newEntries, "Nuevo").apply {
            color = ContextCompat.getColor(binding.root.context, R.color.colornew)
            valueTextColor = labelTextColor
        }

        val xAxis = barChart.xAxis
        val yAxisLeft = barChart.axisLeft
        val yAxisRight = barChart.axisRight

        xAxis.textColor = labelTextColor
        yAxisLeft.textColor = labelTextColor
        yAxisRight.textColor = labelTextColor
        xAxis.gridColor = labelTextColor
        yAxisLeft.gridColor = labelTextColor
        yAxisRight.gridColor = labelTextColor

        val legend = barChart.legend
        legend.textColor = labelTextColor

        val description = barChart.description
        description.text = "COVID-19 Cases in ${item.country}"
        description.textColor = labelTextColor

        val data = BarData(totalDataSet, newDataSet)
        barChart.data = data
    }
}