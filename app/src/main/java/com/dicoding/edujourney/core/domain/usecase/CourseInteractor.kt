package com.dicoding.edujourney.core.domain.usecase

import com.dicoding.edujourney.core.domain.model.Course
import com.dicoding.edujourney.core.source.CourseRepository
import com.dicoding.edujourney.core.source.Resource
import kotlinx.coroutines.flow.Flow

class CourseInteractor(private val courseRepository: CourseRepository) :CourseUseCase {
    override fun getCourse(): Flow<Resource<List<Course>>> = courseRepository.getCourse()

    override fun getDetail(id: Int): Flow<Course> = courseRepository.getDetail(id)

    override fun getEnrolledCourse(): Flow<List<Course>>  = courseRepository.getEnrolledCourse()

    override fun getSearch(query: String): Flow<List<Course>> = courseRepository.getSearch(query)

    override fun setEnroll(course: Course, bought: Boolean) = courseRepository.setEnroll(course,bought)
}