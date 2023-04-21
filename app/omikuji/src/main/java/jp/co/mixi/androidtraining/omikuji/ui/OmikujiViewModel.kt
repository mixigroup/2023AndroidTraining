package jp.co.mixi.androidtraining.omikuji.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import jp.co.mixi.androidtraining.omikuji.data.repository.DefaultOmikujiRepository
import jp.co.mixi.androidtraining.omikuji.data.repository.OmikujiRepository

class OmikujiViewModel(
    private val repository: OmikujiRepository = DefaultOmikujiRepository()
) : ViewModel() {

    var uiState by mutableStateOf(OmikujiUiState())
        private set

    fun pick() {
        val result = repository.getResult()
        uiState = uiState.copy(result = result)
    }
}
