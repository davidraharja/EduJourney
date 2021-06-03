package com.dicoding.edujourney.core.domain.model

data class Module(
    var moduleId: String,
    var courseId: String,
    var title: String,
    var position: Int,
)