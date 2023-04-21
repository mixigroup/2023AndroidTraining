package jp.co.mixi.androidtraining.omikuji.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
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
import jp.co.mixi.androidtraining.omikuji.R

@Composable
fun OmikujiScreen(
    modifier: Modifier = Modifier,
    viewModel: OmikujiViewModel = viewModel()
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val uiState = viewModel.uiState

        Text(
            text = uiState.result,
            fontSize = 24.sp
        )
        Button(onClick = viewModel::pick) {
            Text(text = stringResource(R.string.pick_omikuji))
        }
    }
}

@Preview
@Composable
private fun OmikujiScreenPreview() {
    MaterialTheme {
        OmikujiScreen()
    }
}
