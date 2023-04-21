package jp.co.mixi.androidtraining.todo.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import jp.co.mixi.androidtraining.todo.data.entity.Task

class ToDoViewModel : ViewModel() {

    var uiState by mutableStateOf(ToDoUiState())
        private set

    fun setInputText(text: String) {
        uiState = uiState.copy(
            inputText = text
        )
    }

    fun addTask() {
        uiState = uiState.copy(
            tasks = listOf(Task(uiState.inputText)) + uiState.tasks,
            inputText = ""
        )
    }

    fun deleteTask(task: Task) {
        uiState = uiState.copy(
            tasks = uiState.tasks - task
        )
    }
}
