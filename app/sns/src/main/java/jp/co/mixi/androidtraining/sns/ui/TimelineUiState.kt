package jp.co.mixi.androidtraining.sns.ui

import jp.co.mixi.androidtraining.sns.data.entity.Post

sealed class TimelineUiState {
    data class Success(val posts: List<Post> = emptyList()) : TimelineUiState()
    object Loading : TimelineUiState()
    object Error : TimelineUiState()
}
