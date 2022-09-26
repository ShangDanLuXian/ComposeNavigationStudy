package com.example.composenavigation.Screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.composenavigation.MainActivity
import com.example.composenavigation.MainViewModel
import com.example.composenavigation.navigation.Screen

@Composable
fun HomeScreen(){
    val viewModel: MainViewModel = viewModel(LocalContext.current as MainActivity)
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Home", textAlign = TextAlign.Center)
        Button(onClick = {
            viewModel.navControl.navigate(Screen.Home.route, Screen.CommentList.route)
        }) {
            Text(text = "Next")
        }
    }
}