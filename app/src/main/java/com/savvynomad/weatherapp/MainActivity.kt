package com.savvynomad.weatherapp

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.savvynomad.weatherapp.databinding.ActivityMainBinding
import com.savvynomad.weatherapp.util.Constants.LOCATION
import com.savvynomad.weatherapp.viewmodel.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()

    }

    private fun initView() {
        viewModel.listForecast.observe(this,
            { t ->
                binding.apply {
                    tvLocation.text = LOCATION
                    tvState.text = t.description
                    tvCurrentTemp.text = t.temperature
                    tvForecastDay1.text = t.forecast[0].temperature
                    tvForecastDay2.text = t.forecast[1].temperature
                    tvForecastDay3.text = t.forecast[2].temperature
                }
            })
    }
}