package com.example.lookatyourself

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import com.example.lookatyourself.ui.theme.LookAtYourselfTheme

object Ext {

    internal fun Modifier.rootElementSettings() = composed {
        windowInsetsPadding(WindowInsets.systemBars)
            .fillMaxSize()
            .background(LookAtYourselfTheme.colors.bgPrimary)
    }
}
