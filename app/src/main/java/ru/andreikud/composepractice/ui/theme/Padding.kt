package ru.andreikud.composepractice.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

interface PaddingScheme {
    val smallPadding: Dp
}

class LightPaddingScheme : PaddingScheme {
    override val smallPadding: Dp
        @get:Composable get() = 8.dp
}

class DarkPaddingScheme : PaddingScheme {
    override val smallPadding: Dp
        @get:Composable get() = 32.dp
}

val LocalPadding = staticCompositionLocalOf<PaddingScheme> { LightPaddingScheme() }

val MaterialTheme.padding
    @Composable @ReadOnlyComposable get() = LocalPadding.current