package com.savvynomad.weatherapp.model

data class WeatherResponse(
    val description: String,
    val forecast: List<Forecast>,
    val temperature: String,
    val wind: String
)