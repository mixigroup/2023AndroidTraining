package jp.co.mixi.androidtraining.weather.data.repository

import kotlinx.coroutines.delay

interface WeatherRepository {
    suspend fun getWeather(): String
}

class DefaultWeatherRepository : WeatherRepository {
    override suspend fun getWeather(): String {
        // 実際はネットワークから取得することを想定しています
        delay(2000)
        return listOf("晴れ", "曇り", "雨").random()
    }
}
