package jp.co.mixi.androidtraining.sns.ui

import jp.co.mixi.androidtraining.sns.data.entity.Post

data class TimelineUiState(
    val posts: List<Post> = emptyList()
)
