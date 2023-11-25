package com.example.myapplication.data.network.model

/**
 * Class that represents an object "Cases"
 * @property total Total cases of covid-19 of a country in an specific date
 * @property new New cases of covid-19 of a country in an specific date
 */
data class Cases(
    val total: Int,
    val new: Int
)
