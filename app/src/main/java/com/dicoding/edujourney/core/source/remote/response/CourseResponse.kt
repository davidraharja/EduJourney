package com.dicoding.edujourney.core.source.remote.response

data class CourseResponse(
    var courseId: Int,
    var imageUrl: String,
    var title: String,
    var price: Int,
    var isBought: Boolean = false
)
