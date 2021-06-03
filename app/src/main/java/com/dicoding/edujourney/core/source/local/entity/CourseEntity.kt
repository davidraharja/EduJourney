package com.dicoding.edujourney.core.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "course_table")
data class CourseEntity(
    @PrimaryKey
    @NonNull
    var courseId: Int,

    @ColumnInfo(name = "image_url")
    var image: String,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "price")
    var price: Int,

    @ColumnInfo(name = "bought")
    var isBought: Boolean = false
)