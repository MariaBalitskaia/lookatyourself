package com.example.lookatyourself.ui.theme

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable

@Composable
fun LookAtYourselfTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    colors: LookAtYourselfColors = lookAtYourselfColors(),
    buttonColors: SelfButtonColors = selfButtonColors(),
    typography: LookAtYourselfTypography = LookAtYourselfTypography(),
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalLookAtYourselfColors provides colors,
        LocalSelfButtonColors provides buttonColors,
        LocalLookAtYourselfTypography provides typography,
        LocalTextStyle provides LookAtYourselfTheme.typography.text1Regular,
        LocalContentColor provides colors.textPrimary,
    ) {
        val materialDarkColorPalette = darkColorScheme(
            primary = LookAtYourselfTheme.colors.primary,
            secondary = LookAtYourselfTheme.colors.textSecondary,
            surface = LookAtYourselfTheme.colors.bgPrimary,
            background = LookAtYourselfTheme.colors.bgPrimaryGrey,
            error = LookAtYourselfTheme.colors.textError,
            onPrimary = LookAtYourselfTheme.colors.textStaticWhite
        )

        val materialColorPalette = lightColorScheme(
            primary = LookAtYourselfTheme.colors.primary,
            secondary = LookAtYourselfTheme.colors.textSecondary,
            surface = LookAtYourselfTheme.colors.bgPrimary,
            background = LookAtYourselfTheme.colors.bgPrimaryGrey,
            error = LookAtYourselfTheme.colors.textError,
            onPrimary = LookAtYourselfTheme.colors.textStaticWhite
        )

        val materialColors = if (darkTheme) {
            materialDarkColorPalette
        } else {
            materialColorPalette
        }

        MaterialTheme(
            colorScheme = materialColors,
        ) {
            CompositionLocalProvider(
                LocalIndication provides rememberRipple(color = LookAtYourselfTheme.colors.primary),
                content = content,
            )
        }
    }
}

object LookAtYourselfTheme {

    val colors: LookAtYourselfColors
        @Composable
        @ReadOnlyComposable
        get() = LocalLookAtYourselfColors.current

    val typography: LookAtYourselfTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalLookAtYourselfTypography.current

    val buttonColors: SelfButtonColors
        @Composable
        @ReadOnlyComposable
        get() = LocalSelfButtonColors.current

}