package com.example.randomusers.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.randomusers.R
import com.example.randomusers.UserViewModel

@Composable
fun UserDetail(userViewModel: UserViewModel) {

    val user = userViewModel.selectedUser.value

    if (user != null) {

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            item {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Center
                ) {
                    Image(
                        painter = rememberImagePainter(user.picture.large),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(4.dp)
                            .size(256.dp)
                            .clip(shape = CircleShape)
                            .border(2.dp, Color.LightGray, shape = CircleShape),
                    )
                }
            }
            item {
                Spacer(modifier = Modifier.height(8.dp))
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Center
                ) {
                    Text(
                        fontSize = 24.sp,
                        text = "${user.name.title} ${user.name.first} ${user.name.last}",
                        style = MaterialTheme.typography.bodyMedium,
                    )
                }
            }
            item {
                Spacer(modifier = Modifier.height(32.dp))
                Text(text = stringResource(R.string.email, user.email))
            }
            item {
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    text = stringResource(R.string.phone, user.phone),
                )
            }
            item {
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    text = stringResource(
                        R.string.address,
                        user.location.street.number,
                        user.location.street.name,
                        user.location.city,
                        user.location.state,
                        user.location.country,
                        user.location.postcode
                    )
                )
            }
            item {
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    text = stringResource(
                        R.string.coordinates,
                        user.location.coordinates.latitude,
                        user.location.coordinates.longitude
                    )
                )
            }
            item {
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    text = stringResource(
                        R.string.timezone,
                        user.location.timezone.description,
                        user.location.timezone.offset
                    )
                )
            }
            item {
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    text = stringResource(
                        R.string.login,
                        user.login.username,
                    )
                )
            }
            item {
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    text = stringResource(
                        R.string.password,
                        user.login.password
                    )
                )
            }
        }
    } else {
        Text(text = stringResource(R.string.the_user_was_not_found))
    }
}