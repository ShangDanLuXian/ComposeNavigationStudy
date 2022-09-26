package com.example.composenavigation

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Comment(
    val name: String,
    val content: String,
    var likeState: Boolean
): Parcelable