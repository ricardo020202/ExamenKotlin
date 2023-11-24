package com.example.myapplication.framework.views

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication.framework.adapters.Adapter
import com.example.myapplication.framework.viewmodels.ViewModel

class MainActivity: AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val adapter : Adapter = Adapter(listOf())
    private val viewModel: ViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializeBinding()
        initializeObservers()
        viewModel.getList()
    }

    private fun initializeBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Configure RecyclerView
        binding.RVCountry.setHasFixedSize(true)
        binding.RVCountry.layoutManager = GridLayoutManager(this, 1)
        binding.RVCountry.adapter = adapter
    }

    private fun initializeObservers() {
        //Observe the countriesLiveData and update the adapter when it changes
        viewModel.LiveData.observe(this) { countries ->
            adapter.updateCountries(countries)
        }
    }
}