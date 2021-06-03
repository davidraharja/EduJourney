package com.dicoding.edujourney.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Course(
    var courseId: String,
    var image: String,
    var title: String,
    var description: String,
    var type: String,
    var price: Int,
    var recommended: Boolean,
    var isBought: Boolean
) :Parcelable
