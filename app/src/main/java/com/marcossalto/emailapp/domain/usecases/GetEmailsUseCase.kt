package com.marcossalto.emailapp.domain.usecases

import com.marcossalto.emailapp.domain.repository.EmailRepository
import com.marcossalto.emailapp.domain.repository.Emails
import javax.inject.Inject

class GetEmailsUseCase@Inject constructor(
    private val emailRepository: EmailRepository
) {
    suspend operator fun invoke(): Emails = emailRepository.getAllEmails()
}
