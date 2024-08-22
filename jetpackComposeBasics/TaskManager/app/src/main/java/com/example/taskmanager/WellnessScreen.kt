package com.example.taskmanager

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun WellnessScreen (
    modifier: Modifier = Modifier,
    wellnessViewModel: WellnessViewModel = viewModel()
) {
    Column(modifier = modifier) {
        StatefulWaterCounter()

        val list = wellnessViewModel.tasks
        WellnessTasksList(
            list,
            onCheckedTask = { task, isChecked -> wellnessViewModel.changeTaskChecked(task, isChecked) },
            onCloseTask = { task -> wellnessViewModel.remove(task) }
        )
    }
}