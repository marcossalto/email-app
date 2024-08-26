package com.marcossalto.emailapp.ui.screens.home

import com.marcossalto.emailapp.domain.repository.Emails

data class HomeState(
    val emails: Emails = emptyList()
)
