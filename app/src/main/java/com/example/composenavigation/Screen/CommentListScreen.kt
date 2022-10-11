package com.example.composenavigation.Screen
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composenavigation.*
import com.example.composenavigation.navigation.ParamSet
import com.example.composenavigation.navigation.Screen


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CommentListScreen(

) {
    val viewModel: MainViewModel = viewModel(LocalContext.current as MainActivity)
    val comments : List<Comment> =
    List(100) {Comment("Sev$it", "Hello$it", false)}
    viewModel.setupStickers()
    val coroutineScope = rememberCoroutineScope()
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberBottomSheetState(initialValue = BottomSheetValue.Collapsed)
    )
    val bottomSheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    viewModel.setUpBottomSheetState(bottomSheetScaffoldState, coroutineScope)
    Column {
        StickerList(list = viewModel.commentScreenUiState.stickers,
            userReactedStickerUiState = viewModel.commentScreenUiState.userReactedSticker,
            onStickerClicked = {index -> viewModel.updateSticker(index) },
        onAddStickerClicked = { viewModel.addStickerClicked() })
        LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
            items(items = comments) {
                CommentCard(it, replyListener = {
                    viewModel.navControl.navigate(
                        Screen.Home.route,
                        Screen.Reply.route,
                        ParamSet.ReplyParamSet(it, "Hi")
                    )
                })

            }
        }
        SelectStickerPanel(bottomSheetScaffoldState = viewModel.bottomSheetScaffoldState)
    }
}