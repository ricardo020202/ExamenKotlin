package com.example.myapplication.data.network

import com.example.myapplication.data.network.model.Country
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.myapplication.data.network.model.Res
import com.example.myapplication.utils.Constants

class ApiClient {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val api: ApiService = retrofit.create(ApiService::class.java)

    suspend fun getList(): List<Country>?{
        return try {
            val response = api.getList(Constants.TOKEN)
            if (response.isSuccessful) {
                response.body()
            } else {
                // Error handling
                null
            }
        } catch (e: Exception) {
            // Exception handling
            e.printStackTrace()
            null
        }
    }
}