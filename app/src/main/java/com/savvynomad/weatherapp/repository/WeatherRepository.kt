package com.savvynomad.weatherapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.savvynomad.weatherapp.api.ApiService
import com.savvynomad.weatherapp.model.Forecast
import javax.inject.Inject

class WeatherRepository
@Inject constructor(private val apiService: ApiService){

    suspend fun getWeather() = apiService.getWeatherInfo()

}
