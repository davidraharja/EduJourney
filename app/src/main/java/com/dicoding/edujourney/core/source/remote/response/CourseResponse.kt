package com.dicoding.edujourney.core.source.remote.response

data class CourseResponse(
    var courseId: String,
    var image: String,
    var title: String,
    var description: String,
    var type: String,
    var price: Int,
    var recommended: Boolean,
    var isBought: Boolean = false
)
