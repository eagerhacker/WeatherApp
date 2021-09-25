package com.savvynomad.weatherapp.api

import com.savvynomad.weatherapp.model.WeatherResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("weather/helsinki")
    suspend fun getWeatherInfo() : Response<WeatherResponse>
}