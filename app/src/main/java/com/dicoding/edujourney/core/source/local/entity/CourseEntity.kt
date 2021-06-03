package com.dicoding.edujourney.core.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "course_table")
data class CourseEntity(
    @PrimaryKey
    @NonNull
    var courseId: String,

    @ColumnInfo(name = "image")
    var image: String,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "description")
    var description: String,

    @ColumnInfo(name = "type")
    var type: String,

    @ColumnInfo(name = "price")
    var price: Int,

    @ColumnInfo(name = "recommend")
    var recommended: Boolean,

    @ColumnInfo(name = "bought")
    var isBought: Boolean = false
)