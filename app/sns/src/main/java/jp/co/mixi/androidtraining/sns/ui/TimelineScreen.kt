package jp.co.mixi.androidtraining.sns.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import jp.co.mixi.androidtraining.sns.R
import jp.co.mixi.androidtraining.sns.data.entity.Post
import jp.co.mixi.androidtraining.sns.data.entity.User

@Composable
fun TimelineScreen(
    modifier: Modifier = Modifier,
    viewModel: TimelineViewModel = viewModel()
) {
    when (val uiState = viewModel.uiState) {
        is TimelineUiState.Success -> SuccessScreen(
            uiState = uiState,
            modifier = modifier
        )

        is TimelineUiState.Loading -> LoadingScreen(
            modifier = modifier
        )

        is TimelineUiState.Error -> ErrorScreen(
            onRetryButtonClick = viewModel::getTimeline,
            modifier = modifier
        )
    }
    LaunchedEffect(Unit) {
        viewModel.getTimeline()
    }
}

@Composable
private fun SuccessScreen(
    uiState: TimelineUiState.Success,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(uiState.posts) { post ->
            PostItem(
                post = post,
                modifier = Modifier.fillMaxWidth()
            )
            Divider()
        }
    }
}

@Composable
private fun LoadingScreen(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
private fun ErrorScreen(
    onRetryButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = stringResource(id = R.string.get_timeline_failed))
        Button(onClick = onRetryButtonClick) {
            Text(text = stringResource(R.string.retry))
        }
    }
}

@Preview
@Composable
private fun SuccessScreenPreview() {
    MaterialTheme {
        SuccessScreen(
            uiState = TimelineUiState.Success(
                posts = listOf(
                    Post(
                        author = User(
                            name = "User Name",
                            photoUrl = ""
                        ),
                        content = "Content"
                    )
                )
            ),
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Preview
@Composable
private fun LoadingScreenPreview() {
    MaterialTheme {
        LoadingScreen(
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Preview
@Composable
private fun ErrorScreenPreview() {
    MaterialTheme {
        ErrorScreen(
            onRetryButtonClick = {},
            modifier = Modifier.fillMaxSize()
        )
    }
}
