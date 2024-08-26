package com.marcossalto.emailapp.domain.usecases

import com.marcossalto.emailapp.domain.repository.EmailRepository
import com.marcossalto.emailapp.domain.repository.Emails
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetEmailsUseCase@Inject constructor(
    private val emailRepository: EmailRepository
) {
    operator fun invoke(): Flow<Emails> = emailRepository.getAllEmails()
}
