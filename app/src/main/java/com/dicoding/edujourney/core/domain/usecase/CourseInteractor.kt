package com.dicoding.edujourney.core.domain.usecase

import com.dicoding.edujourney.core.domain.model.Course
import com.dicoding.edujourney.core.domain.repository.ICourseRepository
import com.dicoding.edujourney.core.source.Resource
import kotlinx.coroutines.flow.Flow

class CourseInteractor(private val courseRepository: ICourseRepository) :CourseUseCase {
    override fun getCourse(): Flow<Resource<List<Course>>> = courseRepository.getCourse()

    override fun getDetail(id: String): Flow<Course> = courseRepository.getDetail(id)

    override fun getEnrolledCourse(): Flow<List<Course>>  = courseRepository.getEnrolledCourse()

    override fun getSearch(query: String): Flow<List<Course>> = courseRepository.getSearch(query)

    override fun setEnroll(course: Course, bought: Boolean) = courseRepository.setEnroll(course,bought)
}