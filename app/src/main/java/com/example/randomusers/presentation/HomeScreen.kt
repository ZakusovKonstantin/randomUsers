package com.example.randomusers.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.randomusers.R
import com.example.randomusers.UserUiState
import com.example.randomusers.UserViewModel

@Composable
fun HomeScreen(
    userUiState: UserUiState,
    navController: NavController,
    userViewModel: UserViewModel
) {
    when (userUiState) {
        is UserUiState.Loading -> LoadingScreen(modifier = Modifier.fillMaxSize())
        is UserUiState.Success -> UserList(
            users = userUiState.users,
            navController = navController,
            userViewModel
        )

        is UserUiState.Error -> ErrorScreen(modifier = Modifier.fillMaxSize())
    }
}

@Composable
fun LoadingScreen(modifier: Modifier) {
    Box(modifier) {
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.loading_img),
                contentDescription = "",
                modifier = Modifier
                    .size(200.dp)
            )
            Text(
                text = stringResource(R.string.loading),
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(top = 16.dp)
            )
        }
    }
}

@Composable
fun ErrorScreen(modifier: Modifier) {
    Box(modifier) {
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.ic_connection_error),
                contentDescription = "",
                modifier = Modifier
                    .size(200.dp)
            )
            Text(
                text = stringResource(R.string.internet_connection_error),
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(top = 16.dp)
            )
        }
    }
}