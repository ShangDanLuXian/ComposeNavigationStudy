package com.example.composenavigation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.dp

@Composable
fun AddSticker(
    stickerUiState: StickerUiState?,
    onClick: () -> Unit = {}
){
    val modifier = Modifier.let {
        var res = it.background(Color.White)
        if (stickerUiState != null){
            res = res.border(
                width = 1.dp,
                brush = SolidColor(Color.Blue),
                shape = RoundedCornerShape(1.dp)
            )
        }
        res.size(100.dp)
            .clip(RoundedCornerShape(10.dp))
            .clickable(onClick = onClick)
    }
    Box(modifier = modifier) {
        Row(){
            Text(text = stickerUiState?.stickerImageRes ?: "Add Sticker", modifier = Modifier.padding(10.dp))
        }

    }
}