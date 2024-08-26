package com.marcossalto.emailapp.data.repository

import com.marcossalto.emailapp.data.source.local.dao.EmailDao
import com.marcossalto.emailapp.domain.model.Email
import com.marcossalto.emailapp.domain.repository.EmailRepository
import com.marcossalto.emailapp.domain.repository.Emails
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class EmailRepositoryImpl @Inject constructor(
    private val emailDao: EmailDao
) : EmailRepository {
    override fun getAllEmails(): Flow<Emails> {
        return emailDao.getAllEmails()
    }

    override suspend fun getEmailById(id: Int): Email? {
        return emailDao.getEmailById(id)
    }

    override suspend fun addEmail(email: Email) {
        emailDao.addEmail(email)
    }

    override suspend fun deleteEmail(email: Email) {
        emailDao.deleteEmail(email)
    }
}
