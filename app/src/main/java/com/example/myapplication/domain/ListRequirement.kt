package com.example.myapplication.domain

import com.example.myapplication.data.Repository
import com.example.myapplication.data.network.model.Country

class ListRequirement {
    private val repository = Repository()

    suspend operator fun invoke(date: String): List<Country>? = repository.getList(date)
}