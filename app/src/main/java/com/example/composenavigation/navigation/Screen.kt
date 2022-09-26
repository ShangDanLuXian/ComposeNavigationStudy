package com.example.composenavigation.navigation

sealed class Screen(val route: String) {
    object Home: Screen("home")
    object CommentList: Screen("comment list")
    object Reply: Screen("reply")

    fun withArgs(vararg args: String): String{
        return buildString {
            append(route)
            args.forEach {
                append("/$it")
            }
        }
    }
}


