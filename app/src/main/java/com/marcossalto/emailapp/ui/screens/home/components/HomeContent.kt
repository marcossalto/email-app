package com.marcossalto.emailapp.ui.screens.home.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.marcossalto.emailapp.domain.model.Email
import com.marcossalto.emailapp.domain.repository.Emails

@Composable
fun HomeContent(
    modifier: Modifier = Modifier,
    onDeleteEmail: (email: Email) -> Unit,
    onViewEmail: (id: Int?) -> Unit,
    emails: Emails = emptyList()
) {
    Surface(
        color = MaterialTheme.colorScheme.surface,
        modifier = modifier
    ) {
        LazyColumn {
            items(emails) { email ->
                EmailItem(
                    modifier = Modifier
                        .fillMaxSize(),
                    email = email,
                    onViewEmail = {
                        onViewEmail(email.id)
                    },
                    onDeleteEmail = {
                        onDeleteEmail(email)
                    }
                )
            }
        }
    }
}
