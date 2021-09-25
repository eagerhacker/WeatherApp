package com.savvynomad.weatherapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.savvynomad.weatherapp.model.WeatherResponse
import com.savvynomad.weatherapp.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel
@Inject constructor(private val repository: WeatherRepository) : ViewModel() {

    private val _response = MutableLiveData<WeatherResponse>()

    val listForecast: LiveData<WeatherResponse>
        get() = _response



    init {
        getWeatherForecast()
    }

    private fun getWeatherForecast() = viewModelScope.launch {
        repository.getWeather().let { response ->
            if (response.isSuccessful) {
                _response.postValue(response.body())
            } else
                Log.d("MainActivityViewModel", "getWeather: ${response.code()}")
        }

    }
}

