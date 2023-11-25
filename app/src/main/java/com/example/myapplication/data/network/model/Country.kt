package com.example.myapplication.data.network.model

/**
 * Class that represents an object "Country"
 *
 * @property country Country from where data is consulted
 * @property region Region within the country
 * @property cases Cases object
 */
data class Country (
    val country : String,
    val region : String,
    val cases: Cases
)