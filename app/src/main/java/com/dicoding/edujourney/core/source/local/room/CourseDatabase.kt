package com.dicoding.edujourney.core.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dicoding.edujourney.core.source.local.entity.CourseEntity

@Database(entities = [CourseEntity::class],version = 1, exportSchema = false)
abstract class CourseDatabase :RoomDatabase(){
    abstract fun courseDao(): CourseDao
}