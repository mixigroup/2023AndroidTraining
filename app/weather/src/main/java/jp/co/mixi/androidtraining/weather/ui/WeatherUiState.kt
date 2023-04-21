package jp.co.mixi.androidtraining.weather.ui

sealed class WeatherUiState {
    data class Success(val weather: String = "") : WeatherUiState()
    object Loading : WeatherUiState()
    object Error : WeatherUiState()
}
