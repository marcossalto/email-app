package com.marcossalto.emailapp.ui

sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object ComposeEmail : Screen("compose_email")
}