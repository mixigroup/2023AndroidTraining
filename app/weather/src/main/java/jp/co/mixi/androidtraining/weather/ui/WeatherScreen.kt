package jp.co.mixi.androidtraining.weather.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import jp.co.mixi.androidtraining.weather.R

@Composable
fun WeatherScreen(
    modifier: Modifier = Modifier,
    viewModel: WeatherViewModel = viewModel()
) {
    when (val uiState = viewModel.uiState) {
        is WeatherUiState.Success -> SuccessScreen(
            uiState = uiState,
            onGetWeatherButtonClick = viewModel::getWeather,
            modifier = modifier
        )

        is WeatherUiState.Loading -> LoadingScreen(
            modifier = modifier
        )

        is WeatherUiState.Error -> ErrorScreen(
            onRetryButtonClick = viewModel::getWeather,
            modifier = modifier
        )
    }
}

@Composable
private fun SuccessScreen(
    uiState: WeatherUiState.Success,
    onGetWeatherButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = uiState.weather,
            fontSize = 24.sp
        )
        Button(onClick = onGetWeatherButtonClick) {
            Text(text = stringResource(R.string.get_weather))
        }
    }
}

@Composable
private fun LoadingScreen(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
private fun ErrorScreen(
    onRetryButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = stringResource(id = R.string.get_weather_failed))
        Button(onClick = onRetryButtonClick) {
            Text(text = stringResource(R.string.retry))
        }
    }
}

@Preview
@Composable
private fun SuccessScreenPreview() {
    MaterialTheme {
        SuccessScreen(
            uiState = WeatherUiState.Success(weather = "晴れ"),
            onGetWeatherButtonClick = {},
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Preview
@Composable
private fun LoadingScreenPreview() {
    MaterialTheme {
        LoadingScreen(
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Preview
@Composable
private fun ErrorScreenPreview() {
    MaterialTheme {
        ErrorScreen(
            onRetryButtonClick = {},
            modifier = Modifier.fillMaxSize()
        )
    }
}
