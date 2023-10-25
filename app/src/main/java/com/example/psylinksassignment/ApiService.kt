package com.example.psylinksassignment

import com.example.psylinksassignment.data.ApiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("{apiKey}/{url}")
    fun checkMaliciousUrl(
        @Path("apiKey") apiKey: String,
        @Path("url") url: String
    ): Call<ApiResponse>
}


