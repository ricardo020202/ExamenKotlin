package com.example.myapplication.data.network

import com.example.myapplication.data.network.model.Country
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

/**
 * Interface that makes the call to the endpoint
 *
 */
interface ApiService {
    /**
     * Get request to endpoint
     *
     * @param token Api key
     * @param date date to be consulted
     */
    @GET("covid19")
    suspend fun getList(@Header("X-Api-Key") token: String, @Query("date") date: String): List<Country>
}