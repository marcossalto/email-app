package com.marcossalto.emailapp.domain.model

sealed class HomeEvent {
    data class OnDeleteEmail(val email: Email) : HomeEvent()
    data class OnViewEmail(val id: Int?) : HomeEvent()
}
