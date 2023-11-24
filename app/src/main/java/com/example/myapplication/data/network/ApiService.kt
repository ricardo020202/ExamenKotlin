package com.example.myapplication.data.network

import com.example.myapplication.data.network.model.Country
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.Response
import retrofit2.http.Query

interface ApiService {
    @GET("covid19?country=mexico")
    suspend fun getList(@Header("X-Api-Key") token: String): Response<List<Country>>
}