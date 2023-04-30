package ru.andreikud.composepractice

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ru.andreikud.composepractice.ui.theme.ComposePracticeTheme
import ru.andreikud.composepractice.ui.theme.myColor
import ru.andreikud.composepractice.ui.theme.myStyle
import ru.andreikud.composepractice.ui.theme.padding

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column {
        Text(
            text = "Hello $name!",
            modifier = modifier,
            color = MaterialTheme.colorScheme.myColor,
            style = MaterialTheme.typography.myStyle,
        )
        Spacer(modifier = Modifier.height(MaterialTheme.padding.smallPadding))
        Text(
            text = "Hello $name! second time!",
            modifier = modifier,
            color = MaterialTheme.colorScheme.myColor,
            style = MaterialTheme.typography.myStyle,
        )
    }
}

@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_NO,
)
@Composable
fun GreetingPreviewLight() {
    ComposePracticeTheme {
        Greeting("Android")
    }
}

@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES,
)
@Composable
fun GreetingPreviewDark() {
    ComposePracticeTheme {
        Greeting("Android")
    }
}