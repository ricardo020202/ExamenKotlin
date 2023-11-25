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

/**
 * Class ViewHolder that binds data
 *
 * @param binding Binding
 */
class ViewHolder(private val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
    /**
     * fun bind Binds data
     *
     * @param item Item to be binded
     */
    fun bind(item: Country){
        // Set the country name in the TextView
        binding.Country.text = item.country

        // Get reference to BarChart from the layout
        val barChart: BarChart = binding.barChart

        // Create lists of bar entries for Total and New datasets
        val totalEntries = mutableListOf<BarEntry>()
        val newEntries = mutableListOf<BarEntry>()

        // Add entries corresponding to the current item
        totalEntries.add(BarEntry(0f, item.cases.total.toFloat()))
        newEntries.add(BarEntry(0f, item.cases.new.toFloat()))

        // Check if the current theme is dark or light
        val isDarkMode = (binding.root.context.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_YES

        // Determine label text color based on the theme
        val labelTextColor = if (isDarkMode) {
            ContextCompat.getColor(binding.root.context, R.color.labelTextDark)
        } else {
            ContextCompat.getColor(binding.root.context, R.color.labelTextLight)
        }

        // Configure Total and New datasets with colors and label text colors
        val totalDataSet = BarDataSet(totalEntries, "Total").apply {
            color = ContextCompat.getColor(binding.root.context, R.color.colortotal)
            valueTextColor = labelTextColor
        }
        val newDataSet = BarDataSet(newEntries, "New").apply {
            color = ContextCompat.getColor(binding.root.context, R.color.colornew)
            valueTextColor = labelTextColor
        }

        // Get references to the chart axes
        val xAxis = barChart.xAxis
        val yAxisLeft = barChart.axisLeft
        val yAxisRight = barChart.axisRight

        // Configure text color for axes based on the theme
        xAxis.textColor = labelTextColor
        yAxisLeft.textColor = labelTextColor
        yAxisRight.textColor = labelTextColor

        // Configure grid line color based on the theme
        xAxis.gridColor = labelTextColor
        yAxisLeft.gridColor = labelTextColor
        yAxisRight.gridColor = labelTextColor

        // Configure text color for legend based on the theme
        val legend = barChart.legend
        legend.textColor = labelTextColor

        // Configure chart description and text color based on the theme
        val description = barChart.description
        description.text = "COVID-19 Cases in ${item.country}"
        description.textColor = labelTextColor

        // Configure datasets in the bar chart
        val data = BarData(totalDataSet, newDataSet)
        barChart.data = data
    }
}