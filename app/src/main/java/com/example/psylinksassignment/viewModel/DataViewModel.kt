package com.example.psylinksassignment.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.psylinksassignment.data.ApiResponse
import com.example.psylinksassignment.repository.DataRepository

class DataViewModel : ViewModel() {

    val myData = MutableLiveData<ApiResponse?>()

    fun checkUrl(apiKey: String, url: String) {
        DataRepository.getDataApiCall(apiKey, url).observeForever { response ->
            myData.value = response
        }
    }
}
