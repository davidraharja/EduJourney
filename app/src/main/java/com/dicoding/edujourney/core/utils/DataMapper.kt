package com.dicoding.edujourney.core.utils

import com.dicoding.edujourney.core.domain.model.Course
import com.dicoding.edujourney.core.source.local.entity.CourseEntity
import com.dicoding.edujourney.core.source.remote.response.CourseResponse

object DataMapper {

    fun mapCourseResponseToEntities(input: List<CourseResponse>): List<CourseEntity> =
        input.map {
            CourseEntity(
                courseId = it.courseId,
                image = it.image,
                title = it.title,
                description = it.description,
                type = it.type,
                price = it.price,
                recommended = it.recommended
            )
        }


    fun mapEntitiesToDomain(input: List<CourseEntity>): List<Course> =
        input.map {
            Course(
                courseId = it.courseId,
                image = it.image,
                title = it.title,
                description = it.description,
                type = it.type,
                price = it.price,
                recommended = it.recommended,
                isBought = it.isBought
            )
        }

    fun mapEntityToDomain(input: CourseEntity): Course =
        Course(
            courseId = input.courseId,
            image = input.image,
            title = input.title,
            description = input.description,
            type = input.type,
            price = input.price,
            recommended = input.recommended,
            isBought = input.isBought
        )
    fun mapDomainToEntity(input: Course): CourseEntity =
        CourseEntity(
            courseId = input.courseId,
            image = input.image,
            title = input.title,
            description = input.description,
            type = input.type,
            price = input.price,
            recommended = input.recommended,
            isBought = input.isBought
        )
}
