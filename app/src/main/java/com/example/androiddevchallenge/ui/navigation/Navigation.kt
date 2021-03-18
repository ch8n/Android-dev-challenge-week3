package com.example.androiddevchallenge.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.ui.screens.LoginScreen
import com.example.androiddevchallenge.ui.screens.OnboardingScreen


sealed class Screen(val route: String) {
    object Onboarding : Screen("onboard")
    object Login : Screen("login")
    object Home : Screen("home")
}


@Composable
fun BloomNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.Onboarding.route
    ) {
        composable(Screen.Onboarding.route) {
            OnboardingScreen(navController = navController)
        }

        composable(Screen.Login.route) {
            LoginScreen(navController = navController)
        }
    }
}
