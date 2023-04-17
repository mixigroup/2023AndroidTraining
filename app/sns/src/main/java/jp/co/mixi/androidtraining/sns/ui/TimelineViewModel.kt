package jp.co.mixi.androidtraining.sns.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import jp.co.mixi.androidtraining.sns.data.repository.DefaultTimelineRepository
import jp.co.mixi.androidtraining.sns.data.repository.TimelineRepository
import kotlinx.coroutines.launch
import java.io.IOException

class TimelineViewModel(
    private val repository: TimelineRepository = DefaultTimelineRepository()
) : ViewModel() {

    var uiState by mutableStateOf(TimelineUiState())
        private set

    fun getTimeline() {
        viewModelScope.launch {
            try {
                val posts = repository.getTimeline()
                uiState = uiState.copy(posts = posts)
            } catch (error: IOException) {
                // TODO エラー画面を表示する
            }
        }
    }
}
