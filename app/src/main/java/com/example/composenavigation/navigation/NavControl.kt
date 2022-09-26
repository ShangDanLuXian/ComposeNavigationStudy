package com.example.composenavigation.navigation

import android.os.Parcelable
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.composenavigation.Comment
import com.example.composenavigation.Screen.CommentListScreen
import com.example.composenavigation.Screen.HomeScreen
import com.example.composenavigation.Screen.ReplyScreen
import kotlinx.parcelize.Parcelize

class NavControl constructor(
    navHostController: NavHostController
) {

    private val navController = navHostController
    @Composable
    fun SetUpNavGraph() {

        NavHost(navController = navController, startDestination = Screen.Home.route) {

            composable(route = Screen.Home.route){
                HomeScreen()
            }
            composable(route = Screen.CommentList.route){
                CommentListScreen()
            }
            composable(
                route = Screen.Reply.route){
                ReplyScreen()
            }
        }

    }

    fun navigate(backRoute: String, destinationRoute: String, paramSet: Parcelable? = null){
        navController.getBackStackEntry(backRoute).savedStateHandle.set(
                key = destinationRoute,
                value = paramSet
        )
        navController.navigate(destinationRoute){
            popUpTo(backRoute)
        }
    }

    fun getArguments(route: String): Parcelable? {
        navController.previousBackStackEntry?.savedStateHandle.let {
            return it?.get<Parcelable>(route)
        }
    }

}

sealed class Screen(val route: String) {
    object Home: Screen("home")
    object CommentList: Screen("comment list")
    object Reply: Screen("reply")

}

@Parcelize
data class ReplyParamSet(
    val comment: Comment,
    val hello: String
): Parcelable