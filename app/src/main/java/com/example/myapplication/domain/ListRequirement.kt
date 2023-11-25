package com.example.myapplication.domain

import com.example.myapplication.data.Repository
import com.example.myapplication.data.network.model.Country

/**
 * Class that contains bussines logic
 */
class ListRequirement {
    private val repository = Repository()

    /**
     * fun Invoke Calls getList from repository
     *
     * @param date Date to be consulted
     * @return Country List of countries
     */
    suspend operator fun invoke(date: String): List<Country>? = repository.getList(date)
}