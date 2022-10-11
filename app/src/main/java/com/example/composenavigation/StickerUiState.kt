package com.example.composenavigation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class StickerUiState(
    val stickerImageRes: String,
    var userReacted: MutableState<Boolean> = mutableStateOf(false),
    var reactedCount: MutableState<Int> = mutableStateOf(0)
)