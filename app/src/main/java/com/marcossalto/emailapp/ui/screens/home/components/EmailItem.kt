package com.marcossalto.emailapp.ui.screens.home.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.marcossalto.emailapp.core.toHslColor
import com.marcossalto.emailapp.domain.model.Email

@Composable
fun EmailItem(
    modifier: Modifier,
    email: Email,
    onViewEmail: () -> Unit,
    onDeleteEmail: () -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                horizontal = 8.dp,
                vertical = 8.dp
            ),
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(
            corner = CornerSize(16.dp)
        ),
        onClick = onViewEmail
    ) {
        ConstraintLayout(
            modifier = Modifier
                .wrapContentHeight()
                .wrapContentSize()
                .fillMaxWidth()
                .padding(8.dp)
                .drawBehind { drawRect(color = Color.Transparent) }

        ) {
            val (avatar, sender, subject, body, delete) = createRefs()
            val color = remember(email) {
                Color("${email.id} / ${email.sender}".toHslColor())
            }

            Surface(
                shape = CircleShape,
                modifier = Modifier
                    .constrainAs(avatar) {
                        start.linkTo(parent.start)
                        top.linkTo(parent.top)
                    }
                    .padding(8.dp)
                    .size(52.dp),
                color = color
            ) {
                Text(
                    text = email.sender.first().toString(),
                    modifier = Modifier
                        .wrapContentSize(),
                    style = MaterialTheme.typography.headlineSmall
                )
            }

            BasicText(
                modifier = Modifier
                    .constrainAs(sender) {
                        start.linkTo(avatar.end)
                        top.linkTo(avatar.top)
                        end.linkTo(delete.start)
                        width = Dimension.fillToConstraints
                    }
                    .padding(
                        start = 8.dp, end = 8.dp),
                text = email.sender,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.headlineSmall
            )

            BasicText(
                modifier = Modifier
                    .constrainAs(subject) {
                        start.linkTo(sender.start)
                        top.linkTo(sender.bottom)

                    }
                    .padding(start = 8.dp, end = 8.dp),
                text = email.subject,
                style = MaterialTheme.typography.bodyLarge.copy(color = Color.Black)
            )

            BasicText(
                modifier = Modifier
                    .constrainAs(body) {
                        start.linkTo(sender.start)
                        top.linkTo(subject.bottom)
                    }
                    .padding(start = 8.dp, end = 8.dp),
                text = email.body,
                style = MaterialTheme.typography.bodyMedium.copy(color = Color.Black)
            )

            IconButton(
                modifier = Modifier.constrainAs(delete) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                },
                onClick = onDeleteEmail
            ) {
                Icon(
                    imageVector = Icons.Filled.Delete,
                    contentDescription = null
                )
            }
        }
    }
}

@Preview
@Composable
fun EmailItemPreview() {
    EmailItem(
        modifier = Modifier,
        email = Email(
            id = 1,
            sender = "Sender",
            subject = "Subject",
            body = "Body",
            deliveryTime = "now",
            isUnread = false,
            isStarred = false
        ),
        onViewEmail = {},
        onDeleteEmail = {}
    )
}
