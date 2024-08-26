package com.marcossalto.emailapp.domain.repository

import com.marcossalto.emailapp.domain.model.Email

typealias Emails = List<Email>
interface EmailRepository {
    fun getEmails(): Emails
    fun getEmailById(id: Int): Email
    fun addEmail(email: Email)
    fun deleteEmail(email: Email)
}
