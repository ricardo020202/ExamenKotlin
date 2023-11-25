package com.example.myapplication.framework.views

import com.example.myapplication.R
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.myapplication.databinding.ActivityMainBinding
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication.data.network.model.Country
import com.example.myapplication.framework.adapters.Adapter
import com.example.myapplication.framework.viewmodels.ViewModel
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class MainActivity: AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val adapter : Adapter = Adapter()
    private lateinit var data:ArrayList<Country>
    private val viewModel: ViewModel by viewModels()
    private lateinit var spinner: Spinner
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializeBinding()
        initializeViews()
        initializeObservers()
    }

    private fun initializeBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun initializeViews() {
        spinner = findViewById(R.id.spinner)
        val opciones = generarOpcionesParaAnios(2020, 2020)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, opciones)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        button = findViewById(R.id.button)
        button.setOnClickListener {
            mostrarSeleccion()
        }
    }
    private fun generarOpcionesParaAnios(anioInicial: Int, anioFinal: Int): Array<String> {
        val opciones = mutableListOf<String>()

        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

        for (anio in anioInicial..anioFinal) {
            for (mes in Calendar.FEBRUARY..Calendar.DECEMBER) {
                val calendar = Calendar.getInstance()
                calendar.set(Calendar.YEAR, anio)
                calendar.set(Calendar.MONTH, mes)

                val lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)

                for (day in 1..lastDay) {
                    calendar.set(Calendar.DAY_OF_MONTH, day)
                    val formattedDate = dateFormat.format(calendar.time)
                    opciones.add(formattedDate)
                }
            }
        }

        return opciones.toTypedArray()
    }

    private fun setUpRecyclerView(dataForList: List<Country>) {
        binding.RVCountry.setHasFixedSize(true)

        val gridLayoutManager = GridLayoutManager(this, 1)
        binding.RVCountry.layoutManager = gridLayoutManager

        adapter.Adapter(dataForList, this)
        binding.RVCountry.adapter = adapter
    }

    private fun initializeObservers() {
        viewModel.LiveData.observe(this){ country ->
            setUpRecyclerView(country)
        }
    }

    private fun mostrarSeleccion() {
        val opcionSeleccionada = spinner.selectedItem.toString()

        viewModel.getList(opcionSeleccionada)
    }
}