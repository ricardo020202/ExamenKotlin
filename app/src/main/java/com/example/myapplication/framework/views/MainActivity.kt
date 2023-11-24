package com.example.myapplication.framework.views

import com.example.myapplication.R
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication.data.network.model.Country
import com.example.myapplication.framework.adapters.Adapter
import com.example.myapplication.framework.viewmodels.ViewModel

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
        viewModel.getList()
    }

    private fun initializeBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun initializeViews() {
        // Inicializar Spinner
        spinner = findViewById(R.id.spinner)
        // Configurar el adaptador para el Spinner
        val opciones = arrayOf("Opción 1", "Opción 2", "Opción 3")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, opciones)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        // Inicializar Button
        button = findViewById(R.id.button)
        // Configurar el evento clic del botón
        button.setOnClickListener {
            mostrarSeleccion()
        }
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
        // Obtener la opción seleccionada en el Spinner
        val opcionSeleccionada = spinner.selectedItem.toString()

        // Puedes hacer lo que quieras con la opción seleccionada, por ejemplo, mostrarla en un Toast
        // O imprimirla en el LogCat
        // En este ejemplo, simplemente la imprimiré en el LogCat
        println("Opción seleccionada: $opcionSeleccionada")
    }
}