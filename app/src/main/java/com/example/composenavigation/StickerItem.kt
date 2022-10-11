package com.example.composenavigation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun StickerItem(
    stickerUiState: StickerUiState = StickerUiState("sticker", mutableStateOf(false), mutableStateOf(0)),
    onClick: () -> Unit = {}
){
    val modifier = Modifier.let {
        var res = it.background(Color.White)
        if (stickerUiState.userReacted.value){
            res = res.border(
                width = 1.dp,
                brush = SolidColor(Color.Red),
                shape = RoundedCornerShape(1.dp)
            )
        }
        res.size(100.dp)
            .clip(RoundedCornerShape(10.dp))
            .clickable(onClick = onClick)
    }

    Box(modifier = modifier) {
        Row(){
            Text(text = stickerUiState.stickerImageRes, modifier = Modifier.padding(10.dp))
            Text(text = stickerUiState.reactedCount.value.toString(), modifier = Modifier.padding(10.dp))
        }
        
    }
}