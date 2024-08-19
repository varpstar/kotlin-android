package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.paint
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BusinessCard(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

val kannadaFont = FontFamily(
    Font(R.font.anek_malayalam, FontWeight.Normal),
    Font(R.font.anek_malayalam_bold, FontWeight.Bold)
)

@Composable
fun BusinessCard(modifier: Modifier) {
    val rotated = remember { mutableStateOf(false) }

    val rotation: Float by animateFloatAsState(
        targetValue = if (rotated.value) 180f else 0f,
        animationSpec = tween(500)
    )

    val animateFront by animateFloatAsState(
        targetValue = if (!rotated.value) 1f else 0f,
        animationSpec = tween(500)
    )

    val animateBack by animateFloatAsState(
        targetValue = if (rotated.value) 1f else 0f,
        animationSpec = tween(500)
    )
    Column (
        modifier = modifier
            .fillMaxSize()
            .padding(32.dp)

    ) {
        Box (
            modifier = Modifier
                .graphicsLayer {
                    rotationY = rotation
                    cameraDistance = 8 * density
                }
                .clickable {
                    rotated.value = !rotated.value
                }
                .shadow(
                    elevation = 10.dp,
                    shape = RoundedCornerShape(8.dp)
                )
        ) {
            if (rotated.value) {
                CardBack(
                    modifier = Modifier.graphicsLayer {
                        alpha = animateBack
                    }
                )
            } else {
                CardFace(
                    modifier = Modifier.graphicsLayer {
                        alpha = animateFront
                    }
                )
            }
        }
    }
}

@Composable
fun CardBack(modifier: Modifier) {
    Box (
        modifier = modifier
            .fillMaxSize()
            .graphicsLayer {
                rotationY = -180f
            }
    ) {
        Box (modifier = Modifier
            .fillMaxSize()
            .paint(
                painterResource(id = R.drawable.front_texture),
                contentScale = ContentScale.FillBounds
            )
            .paint(
                painterResource(id = R.drawable.front_line),
                contentScale = ContentScale.Fit
            )
        )
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Text(
                color = colorResource(id = R.color.black),
                text = "Steven P",
                fontWeight = FontWeight.Bold,
                fontSize = 48.sp,
                fontFamily = kannadaFont,
                modifier = Modifier
                    .padding(horizontal = 32.dp)
            )

            Text(
                color = colorResource(id = R.color.black),
                text = "Aut viam inveniam aut faciam",
                fontFamily = kannadaFont,
                modifier = Modifier
                    .padding(top = 4.dp)
            )
        }
        Column (
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                color = colorResource(id = R.color.black),
                fontSize = 15.sp,
                fontFamily = kannadaFont,
                textAlign = TextAlign.Center,
                text = "66 Park Ave, Brooklyn, New York 11205, USA.",
                modifier = Modifier.fillMaxWidth()
            )
            Row (
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min)
                    .padding(top = 4.dp)
            ) {
                Text(
                    color = colorResource(id = R.color.black),
                    fontFamily = kannadaFont,
                    text = "www.varpstar.com"
                )
                VerticalDivider(
                    thickness = 1.dp,
                )
                Text(
                    color = colorResource(id = R.color.black),
                    fontFamily = kannadaFont,
                    text = "info@varpstar.com"
                )
            }
        }
    }
}

@Composable
fun CardFace(modifier: Modifier) {
    val textBackgroundColor = colorResource(id = R.color.white)

    Box (
        modifier = modifier.fillMaxSize()
    ) {
        Box (
            modifier = Modifier
                .fillMaxSize()
                .paint(
                    // Replace with your image id
                    painterResource(id = R.drawable.background),
                    contentScale = ContentScale.FillBounds
                )
        )
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Text(
                color = colorResource(id = R.color.black),
                text = "Steven P",
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp,
                fontFamily = kannadaFont,
                modifier = Modifier
                    .padding(horizontal = 32.dp)
                    .drawBehind {
                        drawRect(
                            color = textBackgroundColor,
                            size = Size(this.size.width + 48, this.size.height),
                            topLeft = Offset(x = -24f, y = 0f)
                        )
                    }
            )

            Text(
                color = colorResource(id = R.color.black),
                text = "Aut viam inveniam aut faciam",
                fontFamily = kannadaFont,
                modifier = Modifier
                    .padding(top = 4.dp)
                    .drawBehind {
                        drawRect(
                            color = textBackgroundColor,
                            size = Size(this.size.width + 48, this.size.height),
                            topLeft = Offset(x = -24f, y = 0f)
                        )
                    }
            )
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCard(modifier = Modifier)
    }
}