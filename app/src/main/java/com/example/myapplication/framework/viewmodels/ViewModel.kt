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

    fun getList(date: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val result: List<Country>? = listRequirement(date)
            //Log.d("Salida", result?.total_results.toString())
            CoroutineScope(Dispatchers.Main).launch {
                LiveData.postValue(result!!)
            }
        }}

}