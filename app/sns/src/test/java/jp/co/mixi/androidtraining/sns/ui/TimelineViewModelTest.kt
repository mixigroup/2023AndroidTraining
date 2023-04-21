package jp.co.mixi.androidtraining.sns.ui

import jp.co.mixi.androidtraining.sns.data.entity.Post
import jp.co.mixi.androidtraining.sns.data.entity.User
import jp.co.mixi.androidtraining.sns.data.repository.TimelineRepository
import jp.co.mixi.androidtraining.sns.util.MainDispatcherRule
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class TimelineViewModelTest {

    @get:Rule
    val dispatcherRule = MainDispatcherRule()

    private val fakeTimeline = listOf(
        Post(author = User(name = "User Name", photoUrl = ""), content = "Content")
    )

    private val fakeRepository = object : TimelineRepository {
        override suspend fun getTimeline(): List<Post> {
            delay(2000)
            return fakeTimeline
        }
    }

    private val viewModel = TimelineViewModel(fakeRepository)

    @Test
    fun testGetTimeline() = runTest {
        assertEquals(TimelineUiState.Success(), viewModel.uiState)
        viewModel.getTimeline()
        advanceUntilIdle()
        assertEquals(TimelineUiState.Success(posts = fakeTimeline), viewModel.uiState)
    }
}
