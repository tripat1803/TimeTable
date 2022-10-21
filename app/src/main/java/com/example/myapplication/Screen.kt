package com.example.myapplication

sealed class Screen(val route: String){
    object  login : Screen(route = "login_screen")
    object timetable : Screen(route = "timetable_screen")
}

