package com.example.taskmanager

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun WellnessTasksList (
    list: List<WellnessTask>,
    onCloseTask: (WellnessTask) -> Unit,
    onCheckedTask: (WellnessTask, Boolean) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn (modifier) {
        items(
            items = list,
            key = { task -> task.id }
        ) {
            task -> WellnessTaskItem(
                taskName = task.label,
                isChecked = task.isChecked,
                onClose = { onCloseTask(task) },
                onCheckedChange = { isChecked -> onCheckedTask(task, isChecked) }
            )
        }
    }
}