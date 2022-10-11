package com.example.composenavigation

import androidx.compose.material.BottomSheetScaffoldState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.ViewModel
import com.example.composenavigation.navigation.NavControl
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
class MainViewModel(
    private val originalList: List<StickerUiState> = mockStickerList(),
): ViewModel(){
    val commentScreenUiState = CommentScreenUiState()
    lateinit var navControl: NavControl
    lateinit var bottomSheetScaffoldState: BottomSheetScaffoldState
    lateinit var coroutineScope: CoroutineScope

    fun setUpBottomSheetState(state: BottomSheetScaffoldState, scope: CoroutineScope){
        bottomSheetScaffoldState = state
        coroutineScope = scope
    }

    fun updateSticker(index: Int){
        commentScreenUiState.apply {
            stickerReact(index)
            stickers.let {
                it.clear()
                it.addAll(getShowStickers())
            }
        }
    }

    fun addStickerClicked(){
        commentScreenUiState.apply {
            addSticker()
        }
        coroutineScope.launch {
            bottomSheetScaffoldState.bottomSheetState.collapse()
        }
    }


    fun setupStickers(){
        commentScreenUiState.stickers.clear()
        commentScreenUiState.stickers.addAll(getShowStickers())
    }


    private fun getShowStickers(): List<StickerUiState> {
        val result = mutableListOf<StickerUiState>()
        val follower = mutableListOf<StickerUiState>()
        originalList.forEach {
            if (it.userReacted.value){
                result.add(it)
                commentScreenUiState.userReactedSticker = it
            } else {
                if (it.reactedCount.value != 0){
                    follower.add(it)
                }
            }
        }
        return result + follower
    }


}


private fun mockStickerList(): List<StickerUiState> = listOf(
    StickerUiState("Sticker1", mutableStateOf(false), mutableStateOf(5)),
    StickerUiState("Sticker2", mutableStateOf(false), mutableStateOf(4)),
    StickerUiState("Sticker3", mutableStateOf(false), mutableStateOf(3)),
    StickerUiState("Sticker4", mutableStateOf(false), mutableStateOf(2)),
    StickerUiState("Sticker5", mutableStateOf(false), mutableStateOf(1)),
)