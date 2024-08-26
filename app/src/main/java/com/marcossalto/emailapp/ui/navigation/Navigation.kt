package com.marcossalto.emailapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.marcossalto.emailapp.ui.Screen
import com.marcossalto.emailapp.ui.screens.composeemail.ComposeEmailScreen
import com.marcossalto.emailapp.ui.screens.home.HomeScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(
            route = Screen.Home.route
        ) {
            HomeScreen(navController = navController)
        }
        composable(
            route = Screen.ComposeEmail.route
        ) {
            ComposeEmailScreen(navController = navController)
        }
    }
}