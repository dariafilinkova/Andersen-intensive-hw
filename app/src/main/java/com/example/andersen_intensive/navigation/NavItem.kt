package com.example.andersen_intensive.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

data class NavItem(
    val label: String,
    val icon: ImageVector,
    val route: String
)

val listOFNavItems = listOf(
    NavItem(
        label = "Homework_1",
        icon = Icons.Default.Home,
        route = Screens.Homework1.name
    ),
    NavItem(
        label = "Contacts",
        icon = Icons.Default.AccountCircle,
        route = Screens.Contacts.name
    ),
)