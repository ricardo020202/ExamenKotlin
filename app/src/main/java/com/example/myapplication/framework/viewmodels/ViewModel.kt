package com.example.myapplication.framework.viewmodels

import androidx.lifecycle.MutableLiveData
import com.example.myapplication.data.network.model.Country
import com.example.myapplication.domain.ListRequirement
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

/**
 * ViewModel class for handling data and business logic related to COVID-19 cases by country
 */
class ViewModel : ViewModel() {
    // LiveData to observe changes in the list of countries
    val LiveData = MutableLiveData<List<Country>>()

    // Instance of the ListRequirement class for data retrieval
    private val listRequirement = ListRequirement()

    /**
     * Function to fetch the list of countries for a given date
     *
     * @param date String representing the date for which the COVID-19 cases are requested
     */
    fun getList(date: String) {
        // Launch a coroutine in the IO dispatcher to perform the data retrieval
        viewModelScope.launch(Dispatchers.IO) {
            // Call the ListRequirement function to fetch the list
            val result: List<Country>? = listRequirement(date)

            // Use the Main dispatcher to update the LiveData with the fetched result
            CoroutineScope(Dispatchers.Main).launch {
                LiveData.postValue(result!!)
            }
        }
    }
}
