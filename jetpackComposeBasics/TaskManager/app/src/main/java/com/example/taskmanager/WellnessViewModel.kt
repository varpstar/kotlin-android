package com.example.taskmanager

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel


class WellnessViewModel: ViewModel() {
    private val _tasks = getWellnessTasks().toMutableStateList();
    val tasks: List<WellnessTask>
        get() = _tasks

    fun remove(item: WellnessTask) {
        _tasks.remove(item);
    }

    fun changeTaskChecked (item: WellnessTask, isChecked: Boolean) {
        _tasks.find { it.id === item.id }?.let { task -> task.isChecked = isChecked }
    }

}

fun getWellnessTasks() = List(30) { i -> WellnessTask(id = i, label = "Task # $i") }
