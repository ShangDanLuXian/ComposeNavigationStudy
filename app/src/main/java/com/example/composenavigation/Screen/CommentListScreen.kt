package com.example.composenavigation.Screen
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.composenavigation.Comment
import com.example.composenavigation.CommentCard
import com.example.composenavigation.navigation.Screen


@Composable
fun CommentListScreen(
    navController: NavHostController,
    comments: List<Comment>
) {
    Comments(navController = navController, comments = comments)
}

@Composable
fun Comments(comments : List<Comment> =
                 List(100) {Comment("Sev$it", "Hello$it", false)}
             , navController: NavHostController){
    LazyColumn(modifier = Modifier.padding(vertical = 4.dp)){
        items(items = comments){
            CommentCard(it, replyListener =  {
                navController.currentBackStackEntry?.savedStateHandle?.set(
                    key = "comment",
                    value = it
                )
                navController.navigate(Screen.Reply.withArgs("primitive"))
            })

        }
    }
}