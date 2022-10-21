package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.R
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    lateinit var navController : NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                navController = rememberNavController()
                SetupNavGraph(navController = navController)
            }
        }
    }
}

//@Composable
//fun DropDown() {
//    Scaffold(
//        topBar = { TopAppBar(title = { Text("Time Table", color = Color.White) }, backgroundColor = Color(0xff0f9d58)) }
//        content =
//    )
//}

@Composable
fun Details(){
    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Column() {
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)) {
                Text(text = "Name:")
                Text(text = "Tripat")
            }
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)) {
                Text(text = "Roll Number:")
                Text(text = "2110991455")
            }
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)) {
                Text(text = "Branch:")
                Text(text = "CSE")
            }
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)) {
                Text(text = "Year:")
                Text(text = "2nd")
            }
        }
    }
}



//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    DropDown()
//}
