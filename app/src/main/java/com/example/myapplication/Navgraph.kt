package com.example.myapplication

import androidx.compose.runtime.Composable
//import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun SetupNavGraph(
    navController : NavHostController
) {
    NavHost ( navController = navController,
        startDestination = Screen.login.route
    ){
        composable(
            route = Screen.login.route

        ){
            login(navController = navController)
        }
        composable(
            route = Screen.timetable.route

        ){
            timetable()
        }
    }
}