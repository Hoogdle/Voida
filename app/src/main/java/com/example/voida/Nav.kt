package com.example.voida

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ShouldPauseCallback
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.voida.Categories.Categories
import com.example.voida.Categories.Data.Category
import com.example.voida.Home.Home

/*
@Composable
fun HomeNav() {
    val navController = rememberNavController()

    Column {
        NavHost(navController = navController, startDestination = "home") {
            composable("home") { Home(navController = navController, modifier = Modifier) }
            composable("category") { Categories(navController = navController) }
        }
    }
}
 */