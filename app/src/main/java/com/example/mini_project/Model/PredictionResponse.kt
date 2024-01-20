package com.example.mini_project.Model

data class PredictionResponse(
    val description: String,
    val diet: List<String>,
    val disease: String,
    val medications: List<String>,
    val precaution: List<String>,
    val workout: List<String>
)
