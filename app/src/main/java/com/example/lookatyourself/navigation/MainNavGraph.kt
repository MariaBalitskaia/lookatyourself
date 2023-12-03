package com.example.lookatyourself.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.lookatyourself.screens.OnboardScreen
import com.example.lookatyourself.screens.SplashScreen
import com.example.lookatyourself.screens.StatusScreen
import com.example.lookatyourself.screens.secondscreen.QuestionsScreen

@Composable
fun MainNavGraph(
    navHostController: NavHostController,
) = NavHost(
    navController = navHostController,
    startDestination = MainScreens.SplashScreen.getComposableRoute(),
) {
    composable(
        route = MainScreens.SplashScreen.getComposableRoute(),
    ) {
        SplashScreen(
            navHostController = navHostController,
        )
    }

    composable(
        route = MainScreens.OnboardingScreen.getComposableRoute(),
    ) {
        OnboardScreen(
            navHostController = navHostController,
        )
    }

    composable(
        route = MainScreens.QuestionsScreen.getComposableRoute(),
    ) {
        QuestionsScreen(
            navHostController = navHostController,
        )
    }
    composable(
        route = MainScreens.StatusScreen.getComposableRoute(),
    ) {
        StatusScreen(
            navHostController = navHostController,
        )
    }
}
