package com.example.lookatyourself

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.lookatyourself.ui.theme.LookAtYourselfTheme

@Composable
fun SelfButton(
    modifier: Modifier = Modifier,
    text: String,
    colors: ButtonColors = LookAtYourselfTheme.buttonColors.primary,
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    Button(
        modifier = Modifier
            .widthIn(64.dp)
            .height(40.dp)
            .then(modifier),
        onClick = onClick,
        elevation = null,
        colors = colors,
        enabled = enabled,
    ) {
        Text(text = text)
    }
}
