package com.example.randomusers.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.randomusers.modelApi.User
import com.example.randomusers.UserViewModel
import com.example.randomusers.ui.theme.UserScreen

@Composable
fun UserList(
    users: List<User>,
    navController: NavController,
    userViewModel: UserViewModel,
) {
    LazyColumn(
        modifier = Modifier.padding(horizontal = 4.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(users) { user ->
            Card(modifier = Modifier.clickable {
                userViewModel.selectedUser.value = user
                navController.navigate(UserScreen.DetailList.name)
            }) {
                UserListItem(user = user)
            }
        }
    }
}


