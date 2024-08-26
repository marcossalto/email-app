package com.marcossalto.emailapp.ui.screens.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marcossalto.emailapp.domain.model.HomeEvent
import com.marcossalto.emailapp.domain.usecases.DeleteEmailUseCase
import com.marcossalto.emailapp.domain.usecases.GetEmailUseCase
import com.marcossalto.emailapp.domain.usecases.GetEmailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val deleteEmailUseCase: DeleteEmailUseCase,
    getEmailsUseCase: GetEmailsUseCase,
    private val getEmailUseCase: GetEmailUseCase
) : ViewModel() {
    private val _state = mutableStateOf(HomeState())
    val state: State<HomeState> = _state

    init {
        getEmailsUseCase().onEach { emails ->
            _state.value = state.value.copy(
                emails = emails
            )
        }.launchIn(viewModelScope)
    }

    fun onEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.OnDeleteEmail -> {
                viewModelScope.launch {
                    deleteEmailUseCase(event.email)
                }
            }
            is HomeEvent.OnViewEmail -> {
                viewModelScope.launch {
                    event.id?.let { getEmailUseCase(it) }
                }
            }
        }
    }
}
