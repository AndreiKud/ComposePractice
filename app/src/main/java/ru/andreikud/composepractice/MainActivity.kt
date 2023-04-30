package ru.andreikud.composepractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.andreikud.composepractice.ui.theme.ComposePracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScreenContent()
        }
    }
}

@Preview(
    showSystemUi = true,
    device = Devices.NEXUS_5X,
)
@Composable
fun LoadingComponentPreview() {
    ScreenContent()
}

@Composable
fun ScreenContent() {
    ComposePracticeTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize()) {
            LoadingComponent(modifier = Modifier.fillMaxSize())
        }
    }
}

@Composable
fun LoadingComponent(modifier: Modifier = Modifier) {
    println(MaterialTheme.colorScheme.surface)
    Surface(
        color = MaterialTheme.colorScheme.surface, modifier = modifier
    ) {
        Box(contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
            Text(
                text = "This may take a while...", modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 16.dp)
            )
        }
    }
}