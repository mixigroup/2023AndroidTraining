package jp.co.mixi.androidtraining.login

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class LoginViewModelTest {

    private val viewModel = LoginViewModel()

    @Test
    fun testLoginEnabled() {
        viewModel.setUserId("oid")
        viewModel.setPassword("passwor")
        assertFalse(viewModel.uiState.loginEnabled)
        viewModel.setUserId("oidy")
        viewModel.setPassword("password")
        assertTrue(viewModel.uiState.loginEnabled)
    }
}
