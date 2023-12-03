package com.example.lookatyourself.navigation

sealed class MainScreens(
    override val baseRoute: String,
) : NavigationEntry {

    object SplashScreen : MainScreens("SPLASH_SCREEN")

    object OnboardingScreen : MainScreens("ONBOARDING_SCREEN")

    object QuestionsScreen : MainScreens("QUESTIONS_SCREEN")

    object StatusScreen : MainScreens("STATUS_SCREEN")
}
