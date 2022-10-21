package com.example.myapplication

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.theme.MyApplicationTheme


@Composable

fun login(navController: NavController) {

    val focusManager = LocalFocusManager.current
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Please login")

        OutlinedTextField(
            value = email,
            placeholder = { Text(text = "user@email.com") },
            label = { Text(text = "email") },
            onValueChange = {email=it},
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() })
        )

        OutlinedTextField(
            value = password,
            placeholder = { Text(text = "password") },
            label = { Text(text = "password") },
            onValueChange = { password=it },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() })
        )

        OutlinedButton(onClick = {
            if (email.isBlank() == false && password.isBlank() == false) {
//                onLoginClick(email)
                focusManager.clearFocus()
            }
            else {
               Modifier.clickable { navController.navigate(route= Screen.timetable.route) }

            }
        }) {
            Text("Login")
        }
    }
}
@Composable
@Preview(showBackground = true)
fun Default(){
    login( navController = rememberNavController())
}
