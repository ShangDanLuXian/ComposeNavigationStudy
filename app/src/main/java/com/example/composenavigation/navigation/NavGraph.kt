package com.example.composenavigation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.composenavigation.Comment
import com.example.composenavigation.Screen.CommentListScreen
import com.example.composenavigation.Screen.ReplyScreen

//TODO back navigation to specific screen
// pass a list
// create a nav class to handle all navigation

@Composable
fun SetUpNavGraph(
    navController: NavHostController
) {
    val comments  =
        List(100) {
            Comment("Sev$it", "Hello$it", false)}
    NavHost(navController = navController, startDestination = Screen.CommentList.route) {

        composable(route = Screen.CommentList.route){
            CommentListScreen(navController = navController, comments = comments)
        }
        composable(
            route = Screen.Reply.route + "/{name}",
            arguments = listOf(
                navArgument("name"){
                    type = NavType.StringType
                }
            )
        ){
            ReplyScreen(navHostController = navController, primitive = it.arguments?.getString("name")!!)
        }
    }
}