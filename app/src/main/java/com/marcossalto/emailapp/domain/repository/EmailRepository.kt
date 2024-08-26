package com.marcossalto.emailapp.domain.repository

import com.marcossalto.emailapp.domain.model.Email

typealias Emails = List<Email>
interface EmailRepository {
    suspend fun getAllEmails(): Emails
    suspend fun getEmailById(id: Int): Email?
    suspend fun addEmail(email: Email)
    suspend fun deleteEmail(email: Email)
}
