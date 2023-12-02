package com.example.lookatyourself.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import com.example.lookatyourself.R

class LookAtYourselfColors(
    val primary: Color,

    val bgPrimary: Color,
    val bgPrimaryGrey: Color,

    val textPrimary: Color,
    val textStaticWhite: Color,
    val textError: Color,
    val textSecondary: Color,
)

@Composable
fun lookAtYourselfColors() = LookAtYourselfColors(
    primary = colorResource(id = R.color.primary),

    bgPrimary = colorResource(id = R.color.backgroundPrimary),
    bgPrimaryGrey = colorResource(id = R.color.backgroundPrimaryGrey),

    textPrimary = colorResource(id = R.color.textPrimary),
    textStaticWhite = colorResource(id = R.color.textStaticWhite),
    textError = colorResource(id = R.color.textError),
    textSecondary = colorResource(id = R.color.textSecondary),
)

internal val LocalLookAtYourselfColors = staticCompositionLocalOf<LookAtYourselfColors> {
    error("CompositionLocal LocalLookAtYourselfColors not present ")
}