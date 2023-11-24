package com.example.myapplication.framework.viewmodels

import androidx.lifecycle.MutableLiveData
import com.example.myapplication.data.network.model.Country
import com.example.myapplication.domain.ListRequirement
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

class ViewModel: ViewModel() {
    val LiveData = MutableLiveData<List<Country>>()
    private val listRequirement = ListRequirement()

    fun getList() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result: List<Country>? = listRequirement() //Fetch country data
                launch(Dispatchers.Main) {
                    result?.let {
                        LiveData.postValue(it) //Update the live data
                    } ?: run {
                    }
                }
            } catch (e: Exception) {

            }
        }
    }

}