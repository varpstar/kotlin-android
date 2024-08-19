package com.example.completedtask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.completedtask.ui.theme.CompletedTaskTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CompletedTaskTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Congratulation(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Congratulation(modifier: Modifier = Modifier) {
    Column (
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Graphics(modifier)
        Title(text = stringResource(R.string.title_text))
        SubTitle(text = stringResource(R.string.subtitle_text))
    }
}

@Composable
fun Graphics(modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.ic_task_completed)

    Image(
        painter = image,
        contentDescription = null,
        modifier,
    )
}

@Composable
fun Title(text: String, modifier: Modifier = Modifier) {
    Text(
        text,
        fontWeight = FontWeight.Bold,
        modifier = modifier.padding(top = 24.dp, bottom = 8.dp)
    )
}

@Composable
fun SubTitle(text: String, modifier: Modifier = Modifier) {
    Text(
        text,
        fontSize = 16.sp
    )
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GreetingPreview() {
    CompletedTaskTheme {
        Congratulation(modifier = Modifier)
    }
}