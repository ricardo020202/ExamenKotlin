package com.example.myapplication.data

import com.example.myapplication.data.network.ApiClient
import com.example.myapplication.data.network.model.Country

/**
 * Repository fetch data from API
 *
 */
class Repository {
    private val api = ApiClient()

    /**
     * fun getList get list of data from API
     *
     * @param date Date to be consulted
     * @return Country List opf countries
     */
    suspend fun getList(date: String): List<Country>? = api.getList(date)
}