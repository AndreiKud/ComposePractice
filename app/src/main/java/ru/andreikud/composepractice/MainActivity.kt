package ru.andreikud.composepractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import ru.andreikud.composepractice.ui.screen.ErrorScreen
import ru.andreikud.composepractice.ui.screen.LoadingScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ErrorScreen()
        }
    }
}

@Composable
private fun Comp1() {

}