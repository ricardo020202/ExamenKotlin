package com.example.myapplication.framework.views

import android.os.Bundle
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializeBinding()
        initializeObservers()
        viewModel.getList()
    }

    private fun initializeBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
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
}