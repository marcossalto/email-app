package com.marcossalto.emailapp.domain.usecases

import com.marcossalto.emailapp.domain.model.Email
import com.marcossalto.emailapp.domain.repository.EmailRepository
import javax.inject.Inject

class DeleteEmailUseCase @Inject constructor(
    private val emailRepository: EmailRepository
) {
    suspend operator fun invoke(email: Email) = emailRepository.deleteEmail(email)
}
