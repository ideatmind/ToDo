package com.ganesh.todo.presentation.home_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.ganesh.todo.model.Todo
import com.ganesh.todo.presentation.common.taskTextStyle

@Composable
fun TodoCard(
    todo: Todo,
    onDone:() -> Unit,
    onUpdate:(id: Int) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(63.dp)
            .background(MaterialTheme.colorScheme.onPrimary)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = { onDone() },
                modifier = Modifier
                    .weight(1f)
            ) {
                Icon(
                    imageVector = Icons.Rounded.Check,
                    tint = androidx.compose.ui.graphics.Color.Magenta,
                    contentDescription = null
                )
            }
            Text(
                todo.task,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .weight(8f),
                style = taskTextStyle
            )
            if (todo.isImportant) {
                Icon(
                    imageVector = Icons.Rounded.Star,
                    tint = androidx.compose.ui.graphics.Color.Red,
                    contentDescription = null,
                    modifier = Modifier
                        .weight(1f)
                )
            }
            IconButton(
                onClick = { onUpdate(todo.id) },
                modifier = Modifier
                    .weight(1f)
            ) {
                Icon(
                    imageVector = Icons.Rounded.Edit,
                    contentDescription = null
                )
            }
        }
    }
}