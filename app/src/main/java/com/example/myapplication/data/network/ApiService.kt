package com.example.myapplication.data.network

import com.example.myapplication.data.network.model.Country
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiService {
    @GET("covid19?date=2020-06-16")
    suspend fun getList(@Header("X-Api-Key") token: String): List<Country>
}