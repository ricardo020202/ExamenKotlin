package com.example.myapplication.data.network

import com.example.myapplication.data.network.model.Country
import com.example.myapplication.utils.Constants

class ApiClient {
    private lateinit var api: ApiService
    suspend fun getList(date: String): List<Country>?{
        api = NetworkModuleDI()
        return try{
            api.getList(Constants.TOKEN, date)
        }catch (e:java.lang.Exception){
            e.printStackTrace()
            null
        }
    }
}