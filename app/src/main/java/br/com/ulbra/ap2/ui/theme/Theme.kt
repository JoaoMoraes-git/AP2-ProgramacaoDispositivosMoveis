package br.com.ulbra.ap2.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext


private val DarkColorScheme = darkColorScheme(
    primary = VermelhoEscuro,
    onPrimary = Color.White,
    primaryContainer = Color(0xFF5C1111),
    onPrimaryContainer = Color(0xFFFFDAD6),
    secondary = Vermelho,
    onSecondary = Color.White,
    background = Color(0xFF1A1111),
    surface = Color(0xFF2B1B1B),
)


private val LightColorScheme = lightColorScheme(
    primary = AzulClaro,
    onPrimary = Color.White,
    primaryContainer = Color(0xFFFFDAD6),
    onPrimaryContainer = Color(0xFF410002),
    secondary = Azul,
    onSecondary = Color.White,
    background = Color(0xFFFFF8F7),
    surface = Color(0xFFFFF0F0)
)

@Composable
fun Ap2Theme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}