package io.github.hydrosemicon.food.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColors = lightColorScheme(
    primary = Color(0xFF8B432D),
    onPrimary = Color.White,
    primaryContainer = Color(0xFFFFDAD0),
    onPrimaryContainer = Color(0xFF381306),
    background = Color(0xFFFFF8F5),
    onBackground = Color(0xFF231A17),
    surface = Color(0xFFFFF8F5),
    onSurface = Color(0xFF231A17),
    onSurfaceVariant = Color(0xFF57423A),
    outline = Color(0xFF8A7268),
)

private val DarkColors = darkColorScheme(
    primary = Color(0xFFFFB59D),
    onPrimary = Color(0xFF54210F),
    primaryContainer = Color(0xFF70301B),
    onPrimaryContainer = Color(0xFFFFDAD0),
    background = Color(0xFF1A120F),
    onBackground = Color(0xFFF3DED5),
    surface = Color(0xFF1A120F),
    onSurface = Color(0xFFF3DED5),
    onSurfaceVariant = Color(0xFFDCC2B7),
    outline = Color(0xFFA78B7E),
)

@Composable
fun FoodTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColors else LightColors,
        content = content,
    )
}
