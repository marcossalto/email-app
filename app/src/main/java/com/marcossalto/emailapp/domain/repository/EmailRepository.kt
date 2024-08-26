package com.marcossalto.emailapp.domain.repository

import com.marcossalto.emailapp.domain.model.Email
import kotlinx.coroutines.flow.Flow

typealias Emails = List<Email>
interface EmailRepository {
    fun getAllEmails(): Flow<Emails>
    suspend fun getEmailById(id: Int): Email?
    suspend fun addEmail(email: Email)
    suspend fun deleteEmail(email: Email)
}
