package ru.andreikud.composepractice.ui.screen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withAnnotation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.andreikud.composepractice.R
import ru.andreikud.composepractice.ui.theme.ComposePracticeTheme

@Preview(
    showSystemUi = true,
)
@Composable
fun ErrorScreenPreview() {
    ErrorScreen()
}

@Composable
fun ErrorScreen() {
    ComposePracticeTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Spacer(modifier = Modifier.height(16.dp))
                ErrorHeader(text = "Failed")
                Spacer(modifier = Modifier.height(16.dp))
                ErrorImage(
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Footer()
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
private fun ErrorImage(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        Image(
            painter = painterResource(id = R.drawable.anime),
            contentDescription = "Anime",
            modifier = modifier
                .clip(RoundedCornerShape(112.dp))
                .border(
                    width = 10.dp, brush = Brush.linearGradient(
                        0.0f to Color.Red, 0.3f to Color.Green, 1.0f to Color.Blue
                    ), shape = RoundedCornerShape(112.dp)
                )
                .rotate(90f)
        )
    }
}

@Composable
private fun ErrorHeader(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = text,
        modifier = modifier,
        style = MaterialTheme.typography.headlineLarge,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
    )
}

@OptIn(ExperimentalTextApi::class)
@Composable
private fun Footer() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "First row")
        val text = buildAnnotatedString {
            withStyle(
                SpanStyle(color = Color.Blue)
            ) {
                withAnnotation(tag = "my_tag", annotation = "blahblah") {
                    append("Second row")
                }
            }
        }
        val ctx = LocalContext.current
        ClickableText(
            text = text,
            onClick = { offset ->
                text.getStringAnnotations("my_tag", offset, offset).firstOrNull()?.let { annotation ->
                    Toast.makeText(ctx, annotation.item, Toast.LENGTH_LONG).show()
                }
            })
    }
}