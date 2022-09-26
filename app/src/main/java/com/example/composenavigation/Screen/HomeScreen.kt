package com.example.composenavigation.Screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import com.example.composenavigation.navigation.Screen

@Composable
fun HomeScreen(
    navController: NavHostController
){
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Home", textAlign = TextAlign.Center)
        Button(onClick = {
            navController.navigate(Screen.CommentList.route)
        }) {
            Text(text = "Next")
        }
    }
}