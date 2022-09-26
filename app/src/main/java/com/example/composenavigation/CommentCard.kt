package com.example.composenavigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun CommentCard(comment: Comment = Comment("Sev", "Hello", false)
, replyListener : () -> Unit = {  }){

    var liked by remember { mutableStateOf(comment.likeState) }
    Column(Modifier.background(MaterialTheme.colors.background).fillMaxWidth()) {
        Row(modifier = Modifier.padding(1.dp)) {
            Button(onClick = {}, modifier = Modifier
                .padding(1.dp)
                .size(10.dp)) {

            }
            Text(text = comment.name, modifier = Modifier.padding(1.dp))
        }
        Text(text = comment.content, modifier = Modifier.padding(1.dp))
        Button(onClick = {
            liked = !liked
            comment.likeState = liked}) {
            Text(text = if (liked) "Liked" else "Like")
        }
        Button(onClick = replyListener) {
            Text(text = "Reply")
        }
    }
}