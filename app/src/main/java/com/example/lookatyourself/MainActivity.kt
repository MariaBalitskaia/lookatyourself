package com.example.lookatyourself

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import com.example.lookatyourself.screens.StartScreen
import com.example.lookatyourself.screens.secondscreen.SecondScreen
import com.example.lookatyourself.ui.theme.LookAtYourselfTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            LookAtYourselfTheme {
                SecondScreen()
            }
        }
    }
}
