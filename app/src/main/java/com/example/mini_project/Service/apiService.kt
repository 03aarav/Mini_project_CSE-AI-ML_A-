package com.example.mini_project.Service

import com.example.mini_project.Model.PredictionResponse
import com.example.mini_project.Model.SymptomRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("predict")
    fun predictDisease(@Body request: SymptomRequest): Call<PredictionResponse>
}