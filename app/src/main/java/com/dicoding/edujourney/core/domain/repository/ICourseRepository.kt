package com.dicoding.edujourney.core.domain.repository

import com.dicoding.edujourney.core.domain.model.Course
import com.dicoding.edujourney.core.source.Resource
import kotlinx.coroutines.flow.Flow

interface ICourseRepository {
    fun getCourse(): Flow<Resource<List<Course>>>
    fun getDetail(id: String): Flow<Course>
    fun getEnrolledCourse(): Flow<List<Course>>

    fun getSearch(query: String): Flow<List<Course>>

    fun setEnroll(course: Course, bought: Boolean)
}