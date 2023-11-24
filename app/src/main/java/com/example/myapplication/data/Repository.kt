package com.example.myapplication.data

import com.example.myapplication.data.network.ApiClient
import com.example.myapplication.data.network.model.Country

class Repository {
    private val api = ApiClient()

    suspend fun getList(): List<Country>? {
        return api.getList()
    }
}