package com.example.composenavigation.Screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.composenavigation.Comment
import com.example.composenavigation.CommentCard
import com.example.composenavigation.MainActivity
import com.example.composenavigation.MainViewModel
import com.example.composenavigation.navigation.ReplyParamSet
import com.example.composenavigation.navigation.Screen

@Composable
fun ReplyScreen() {
    val vm: MainViewModel = viewModel(LocalContext.current as MainActivity)
    val arguments: ReplyParamSet = vm.navControl.getArguments(Screen.Reply.route) as ReplyParamSet
    Column(modifier = Modifier
        .fillMaxSize()
        .clickable { }) {
        arguments.let {
            Text(text = it.hello)
            CommentCard(it.comment)
        }

    }
}