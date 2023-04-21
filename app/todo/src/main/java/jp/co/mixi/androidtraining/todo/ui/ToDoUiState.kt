package jp.co.mixi.androidtraining.todo.ui

import jp.co.mixi.androidtraining.todo.data.entity.Task

data class ToDoUiState(
    val tasks: List<Task> = emptyList(),
    val inputText: String = ""
) {
    val addEnabled: Boolean
        get() = inputText.isNotBlank()
}
