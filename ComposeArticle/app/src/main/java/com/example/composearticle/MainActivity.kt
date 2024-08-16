package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeArticleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Article(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Article(modifier: Modifier = Modifier) {
    Column (modifier) {
        Background(modifier)
        Title(text = stringResource(R.string.title_text))
        Body(text = stringResource(R.string.first_paragraph_text))
        Body(text = stringResource(R.string.second_paragraph_text))
    }
}

@Composable
fun Title(text: String, modifier: Modifier = Modifier) {
    Text (
        text,
        fontSize = 24.sp,
        modifier = modifier.padding(16.dp),
    )
}

@Composable
fun Body(text: String, modifier: Modifier = Modifier) {
    Text (
        text,
        textAlign = TextAlign.Justify,
        modifier = modifier
            .padding(16.dp),
    )
}



@Composable
fun Background(modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.bg_compose_background)

    Image(
        painter = image,
        contentDescription = null,
        modifier
    )
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GreetingPreview() {
    ComposeArticleTheme {
        Article()
    }
}