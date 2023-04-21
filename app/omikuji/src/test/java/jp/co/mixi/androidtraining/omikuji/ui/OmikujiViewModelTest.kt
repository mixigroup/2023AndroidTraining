package jp.co.mixi.androidtraining.omikuji.ui

import jp.co.mixi.androidtraining.omikuji.data.repository.FakeOmikujiRepository
import org.junit.Assert.assertEquals
import org.junit.Test

class OmikujiViewModelTest {

    private val viewModel = OmikujiViewModel(FakeOmikujiRepository())

    @Test
    fun testPick() {
        assertEquals("", viewModel.uiState.result)
        viewModel.pick()
        assertEquals("大吉", viewModel.uiState.result)
    }
}
