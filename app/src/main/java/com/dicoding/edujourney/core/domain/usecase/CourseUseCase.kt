package com.dicoding.edujourney.core.domain.usecase

import com.dicoding.edujourney.core.domain.model.Course
import com.dicoding.edujourney.core.source.Resource
import kotlinx.coroutines.flow.Flow

interface CourseUseCase {
    fun getCourse(): Flow<Resource<List<Course>>>
    fun getDetail(id: Int): Flow<Course>
    fun getEnrolledCourse(): Flow<List<Course>>

    fun getSearch(query: String): Flow<List<Course>>

    fun setEnroll(course: Course, bought: Boolean)
}