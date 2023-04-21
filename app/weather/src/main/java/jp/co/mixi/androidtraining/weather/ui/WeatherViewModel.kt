package jp.co.mixi.androidtraining.weather.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import jp.co.mixi.androidtraining.weather.data.repository.DefaultWeatherRepository
import jp.co.mixi.androidtraining.weather.data.repository.WeatherRepository
import kotlinx.coroutines.launch
import java.io.IOException

class WeatherViewModel(
    private val repository: WeatherRepository = DefaultWeatherRepository()
) : ViewModel() {

    var uiState by mutableStateOf<WeatherUiState>(WeatherUiState.Success())
        private set

    fun getWeather() {
        viewModelScope.launch {
            uiState = WeatherUiState.Loading
            uiState = try {
                val weather = repository.getWeather()
                WeatherUiState.Success(weather = weather)
            } catch (error: IOException) {
                WeatherUiState.Error
            }
        }
    }
}
