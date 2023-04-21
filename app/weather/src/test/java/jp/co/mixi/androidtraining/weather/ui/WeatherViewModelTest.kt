package jp.co.mixi.androidtraining.weather.ui

import jp.co.mixi.androidtraining.weather.data.repository.WeatherRepository
import jp.co.mixi.androidtraining.weather.util.MainDispatcherRule
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class WeatherViewModelTest {

    @get:Rule
    val dispatcherRule = MainDispatcherRule()

    private val fakeRepository = object : WeatherRepository {
        override suspend fun getWeather(): String {
            delay(2000)
            return "晴れ"
        }
    }

    private val viewModel = WeatherViewModel(fakeRepository)

    @Test
    fun testGetWeather() = runTest {
        assertEquals(WeatherUiState.Success(), viewModel.uiState)
        viewModel.getWeather()
        advanceUntilIdle()
        assertEquals(WeatherUiState.Success("晴れ"), viewModel.uiState)
    }
}
