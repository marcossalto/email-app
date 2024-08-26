package com.marcossalto.emailapp.ui.screens.home.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.marcossalto.emailapp.R

@Composable
fun HomeFab(
    modifier: Modifier = Modifier,
    onFabClicked: () -> Unit
) {
    FloatingActionButton(
        modifier = modifier
            .height(52.dp)
            .widthIn(min = 56.dp),
        onClick = onFabClicked
    ) {
        Icon(
            imageVector = androidx.compose.material.icons.Icons.Filled.Add,
            contentDescription = stringResource(id = R.string.compose_email)
        )
    }
}