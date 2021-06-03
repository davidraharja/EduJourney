package com.dicoding.edujourney.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Course(
    var courseId: Int,
    var image: String,
    var title: String,
    var price: Int,
    var isBought: Boolean
) :Parcelable
