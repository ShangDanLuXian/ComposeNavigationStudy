package com.example.composenavigation.Screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController
import com.example.composenavigation.Comment
import com.example.composenavigation.CommentCard

@Composable
fun ReplyScreen(
    navHostController: NavHostController,
    primitive: String) {
    Column(modifier = Modifier
        .fillMaxSize()
        .clickable { }) {
        Text(text = primitive)
        val comment = navHostController.previousBackStackEntry?.savedStateHandle?.get<Comment>("comment")
        comment?.let {
            CommentCard(it)
        }
    }
}