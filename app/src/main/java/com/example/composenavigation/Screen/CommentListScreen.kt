package com.example.composenavigation.Screen
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.composenavigation.Comment
import com.example.composenavigation.CommentCard
import com.example.composenavigation.MainActivity
import com.example.composenavigation.MainViewModel
import com.example.composenavigation.navigation.ParamSet
import com.example.composenavigation.navigation.Screen


@Composable
fun CommentListScreen(

) {
    val comments : List<Comment> =
    List(100) {Comment("Sev$it", "Hello$it", false)}
    Comments(comments = comments)
}

@Composable
fun Comments(comments : List<Comment> =
                 List(100) {Comment("Sev$it", "Hello$it", false)}
             ){
    val viewModel: MainViewModel = viewModel(LocalContext.current as MainActivity)
    LazyColumn(modifier = Modifier.padding(vertical = 4.dp)){
        items(items = comments){
            CommentCard(it, replyListener =  {
                viewModel.navControl.navigate(Screen.Home.route, Screen.Reply.route, ParamSet.ReplyParamSet(it, "Hi"))
            })

        }
    }
}