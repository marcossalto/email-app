package com.marcossalto.emailapp.domain.model

sealed class HomeEvent {
    data class OnDeleteEmail(val email: Email) : HomeEvent()
}
