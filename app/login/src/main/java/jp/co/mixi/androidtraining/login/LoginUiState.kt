package jp.co.mixi.androidtraining.login

data class LoginUiState(
    val userId: String = "",
    val password: String = ""
) {
    val loginEnabled
        get() = userId.length >= 4 && password.length >= 8
}
