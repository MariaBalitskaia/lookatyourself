package com.example.lookatyourself

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.core.view.WindowCompat
import com.example.lookatyourself.navigation.MainNavGraph
import com.example.lookatyourself.ui.theme.LookAtYourselfTheme
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            LookAtYourselfTheme {
                TransparentSystemBars()

                val navController = rememberAnimatedNavController()
                MainNavGraph(navController)
            }
        }
    }
}

@Composable
private fun TransparentSystemBars() {
    val systemUiController = rememberSystemUiController()
    val useDarkIcons = isSystemInDarkTheme()
    val color = LookAtYourselfTheme.colors.bgPrimary
    SideEffect {
        systemUiController.setSystemBarsColor(
            color = color,
            darkIcons = useDarkIcons,
            isNavigationBarContrastEnforced = false,
        )
    }
}
