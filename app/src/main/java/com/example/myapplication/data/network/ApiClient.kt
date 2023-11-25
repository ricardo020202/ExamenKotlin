package com.example.myapplication.data.network

import com.example.myapplication.data.network.model.Country
import com.example.myapplication.utils.Constants

/**
 * Class ApiClient used to handle API connections
 *
 */
class ApiClient {
    private lateinit var api: ApiService

    /**
     * fun getList() Gets list of data from API
     *
     * @param date Date that wants to be consulted
     *
     * @return List<Country> List of countries
     */
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