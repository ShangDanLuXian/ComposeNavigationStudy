package com.example.composenavigation.Screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composenavigation.StickerItem
import com.example.composenavigation.StickerUiState
import com.example.composenavigation.ui.theme.Shapes
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class, ExperimentalFoundationApi::class)
@Composable
fun SelectStickerPanel(
    stickerUiStates: List<StickerUiState> = listOf(
        StickerUiState("Sticker1", mutableStateOf(false), mutableStateOf(5)),
        StickerUiState("Sticker2", mutableStateOf(false), mutableStateOf(4)),
        StickerUiState("Sticker3", mutableStateOf(false), mutableStateOf(3)),
        StickerUiState("Sticker4", mutableStateOf(false), mutableStateOf(2)),
        StickerUiState("Sticker5", mutableStateOf(false), mutableStateOf(1)),
    ),
    bottomSheetScaffoldState: BottomSheetScaffoldState
){
    BottomSheetScaffold( sheetContent = {
        Box {
            Box(modifier = Modifier.fillMaxSize(0.51f))
            LazyVerticalGrid(
                cells = GridCells.Adaptive(100.dp)){
                items(stickerUiStates.size){ stickerUiState ->
                    StickerItem(stickerUiStates[stickerUiState])
                }
            }
        }
    },
        scaffoldState = bottomSheetScaffoldState,
        sheetPeekHeight = 100.dp,
        sheetShape = Shapes.large
    ) {
    }
}