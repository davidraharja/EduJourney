package com.dicoding.edujourney.core.source.local

import com.dicoding.edujourney.core.source.local.entity.CourseEntity
import com.dicoding.edujourney.core.source.local.room.CourseDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val mCourseDao: CourseDao) {
    fun getCourse(): Flow<List<CourseEntity>> = mCourseDao.getCourse()

    fun getEnrolledCourse(): Flow<List<CourseEntity>> = mCourseDao.getEnrolledCourse()

    fun getDetail(id: String): Flow<CourseEntity> = mCourseDao.getDetail(id)

    fun updateEnroll(courseEntity: CourseEntity) = mCourseDao.updateEnroll(courseEntity)

    suspend fun insertCourse(course: List<CourseEntity>) {
        mCourseDao.insertCourse(course)
    }

    fun setEnroll(courseEntity: CourseEntity, bought: Boolean) {
        courseEntity.isBought = bought
        mCourseDao.updateEnroll(courseEntity)
    }

    fun getSearch(query: String): Flow<List<CourseEntity>> = mCourseDao.getSearch(query)


}