package com.example.lookatyourself.ui.theme

import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.res.colorResource
import com.example.lookatyourself.R

@Stable
data class SelfButtonColors(
    val primaryBlack: ButtonColors,
    val primary: ButtonColors,
    val secondary: ButtonColors,
    val additionBlue: ButtonColors,
    val addition: ButtonColors,
    val shimmer: ButtonColors,
)

@Composable
fun selfButtonColors() = SelfButtonColors(
    primaryBlack = buttonColors(
        containerColor = colorResource(id = R.color.backgroundSix),
        contentColor = colorResource(id = R.color.textFour),
        disabledContainerColor = colorResource(id = R.color.backgroundDisabled),
        disabledContentColor = colorResource(id = R.color.textDisabled),
    ),
    primary = buttonColors(
        containerColor = colorResource(id = R.color.backgroundAccent),
        contentColor = colorResource(id = R.color.textStaticWhite),
        disabledContainerColor = colorResource(id = R.color.backgroundDisabledAccent),
        disabledContentColor = colorResource(id = R.color.textDisabledStaticWhite),
    ),
    secondary = buttonColors(
        containerColor = colorResource(id = R.color.backgroundPrimary),
        contentColor = colorResource(id = R.color.textAccent),
        disabledContainerColor = colorResource(id = R.color.backgroundPrimary),
        disabledContentColor = colorResource(id = R.color.textDisabledAccent),
    ),
    additionBlue = buttonColors(
        containerColor = colorResource(id = R.color.backgroundSelected),
        contentColor = colorResource(id = R.color.textAccent),
        disabledContainerColor = colorResource(id = R.color.backgroundSelected),
        disabledContentColor = colorResource(id = R.color.textDisabledAccent),
    ),
    addition = buttonColors(
        containerColor = colorResource(id = R.color.elementsFive),
        contentColor = colorResource(id = R.color.textPrimary),
        disabledContainerColor = colorResource(id = R.color.backgroundDisabled),
        disabledContentColor = colorResource(id = R.color.textDisabled),
    ),
    shimmer = buttonColors(
        containerColor = colorResource(id = R.color.backgroundShimmer),
    ),
)

internal val LocalSelfButtonColors = staticCompositionLocalOf<SelfButtonColors> {
    error("CompositionLocal GpbButtonColors not present")
}
