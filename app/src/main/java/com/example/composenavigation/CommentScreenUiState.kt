package com.example.composenavigation

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList

class CommentScreenUiState(
    val stickers: SnapshotStateList<StickerUiState> = mutableStateListOf(),
    var userReactedSticker: StickerUiState? = null
) {
    fun stickerReact(index: Int){
        stickers[index].apply {
            if (userReacted.value){
                userReacted.value = false
                reactedCount.value --
            } else {
                userReacted.value = true
                reactedCount.value ++
            }
        }
        userReactedSticker?.apply {
            if (this != stickers[index]){
                userReacted.value = false
                reactedCount.value --
                userReactedSticker = stickers[index]
            } else {
                userReactedSticker = null
            }
        }
    }

    fun addSticker(){
        if (userReactedSticker != null){
            userReactedSticker?.apply {
                reactedCount.value --
                userReacted.value = false
                userReactedSticker = null
            }
        } else {

        }
    }
}