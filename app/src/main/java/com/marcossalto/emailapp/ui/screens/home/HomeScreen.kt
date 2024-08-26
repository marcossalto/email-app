package com.marcossalto.emailapp.ui.screens.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.marcossalto.emailapp.domain.model.HomeEvent
import com.marcossalto.emailapp.ui.Screen
import com.marcossalto.emailapp.ui.screens.home.components.HomeContent
import com.marcossalto.emailapp.ui.screens.home.components.HomeFab
import com.marcossalto.emailapp.ui.screens.home.components.HomeTopBar

@Composable
fun HomeScreen(
    navController: androidx.navigation.NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Scaffold(
        topBar = {
            HomeTopBar()
        },
        content = { innerPadding ->
            HomeContent(
                modifier = Modifier
                    .padding(innerPadding),
                onViewEmail = {
                    viewModel.onEvent(
                        event = HomeEvent.OnViewEmail(it)
                    )
                },
                onDeleteEmail = {
                    viewModel.onEvent(
                        event = HomeEvent.OnDeleteEmail(it)
                    )
                },
                emails = state.emails
            )
        },
        floatingActionButton = {
            HomeFab(
                onFabClicked = {
                    navController.navigate(Screen.ComposeEmail.route)
                }
            )
        }
    )
}