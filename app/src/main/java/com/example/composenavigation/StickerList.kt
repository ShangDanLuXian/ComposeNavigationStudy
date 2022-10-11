package com.example.composenavigation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList

@Composable
fun StickerList(
    list: SnapshotStateList<StickerUiState>,
    userReactedStickerUiState: StickerUiState? = null,
    onStickerClicked: (Int) -> Unit,
    onAddStickerClicked: () -> Unit
){
    Row {
        AddSticker(stickerUiState = userReactedStickerUiState, onClick = onAddStickerClicked)
        LazyRow(){
            itemsIndexed(items = list){ index, item ->
                StickerItem(item) { onStickerClicked(index) }
            }
        }
    }
}