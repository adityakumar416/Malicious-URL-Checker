package com.example.psylinksassignment.repository

import androidx.lifecycle.MutableLiveData
import com.example.psylinksassignment.ApiClient
import com.example.psylinksassignment.data.ApiResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object DataRepository {

    private val _apiResponse = MutableLiveData<ApiResponse?>()

    fun getDataApiCall(apiKey: String, url: String): MutableLiveData<ApiResponse?> {
        val call = ApiClient.create().checkMaliciousUrl(apiKey, url)

        call.enqueue(object : Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                if (response.isSuccessful) {
                    _apiResponse.value = response.body()
                } else {
                    _apiResponse.value = null
                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                _apiResponse.value = null
            }
        })

        return _apiResponse
    }
}
