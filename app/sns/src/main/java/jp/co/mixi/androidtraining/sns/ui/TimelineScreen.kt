package jp.co.mixi.androidtraining.sns.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun TimelineScreen(
    modifier: Modifier = Modifier,
    viewModel: TimelineViewModel = viewModel()
) {
    val uiState = viewModel.uiState

    LazyColumn(modifier = modifier) {
        items(uiState.posts) { post ->
            PostItem(
                post = post,
                modifier = Modifier.fillMaxWidth()
            )
            Divider()
        }
    }

    LaunchedEffect(Unit) {
        viewModel.getTimeline()
    }
}
