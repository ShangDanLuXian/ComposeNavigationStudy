package com.example.composenavigation

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.composenavigation.navigation.NavControl


class MainViewModel(): ViewModel(){
    lateinit var navControl: NavControl

}