package com.example.randomusers.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import com.example.randomusers.modelApi.User
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter


@Composable
fun UserListItem(user: User) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = rememberImagePainter(user.picture.large),
            contentDescription = null,
            modifier = Modifier
                .padding(4.dp)
                .size(64.dp)
                .clip(shape = CircleShape)
                .border(2.dp, Color.LightGray, shape = CircleShape)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column {
            Text(
                text = "${user.name.first} ${user.name.last}",
                fontWeight = FontWeight.Bold
            )
            Text(text = "Age: ${user.dob.age} ")
        }
    }
}
