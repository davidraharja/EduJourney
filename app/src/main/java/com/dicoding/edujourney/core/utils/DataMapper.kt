package com.dicoding.edujourney.core.utils

import com.dicoding.edujourney.core.domain.model.Course
import com.dicoding.edujourney.core.source.local.entity.CourseEntity
import com.dicoding.edujourney.core.source.remote.response.CourseResponse

object DataMapper {

    fun mapCourseResponseToEntities(input: List<CourseResponse>): List<CourseEntity> =
        input.map {
            CourseEntity(
                courseId = it.courseId,
                image = it.imageUrl,
                title = it.title,
                price = it.price,
            )
        }


    fun mapEntitiesToDomain(input: List<CourseEntity>): List<Course> =
        input.map {
            Course(
                courseId = it.courseId,
                image = it.image,
                title = it.title,
                price = it.price,
                isBought = it.isBought
            )
        }

    fun mapEntityToDomain(input: CourseEntity): Course =
        Course(
            courseId = input.courseId,
            image = input.image,
            title = input.title,
            price = input.price,
            isBought = input.isBought
        )
    fun mapDomainToEntity(input: Course): CourseEntity =
        CourseEntity(
            courseId = input.courseId,
            image = input.image,
            title = input.title,
            price = input.price,
            isBought = input.isBought
        )
}
