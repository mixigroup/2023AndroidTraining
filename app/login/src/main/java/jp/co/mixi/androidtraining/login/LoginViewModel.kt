package jp.co.mixi.androidtraining.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    var uiState by mutableStateOf(LoginUiState())
        private set

    fun setUserId(userId: String) {
        uiState = uiState.copy(userId = userId)
    }

    fun setPassword(password: String) {
        uiState = uiState.copy(password = password)
    }
}
