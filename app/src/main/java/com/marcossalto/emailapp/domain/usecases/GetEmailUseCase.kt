package com.marcossalto.emailapp.domain.usecases

import com.marcossalto.emailapp.domain.model.Email
import com.marcossalto.emailapp.domain.repository.EmailRepository
import javax.inject.Inject

class GetEmailUseCase  @Inject constructor(
    private val emailRepository: EmailRepository
) {
    suspend operator fun invoke(id: Int): Email? = emailRepository.getEmailById(id)
}
