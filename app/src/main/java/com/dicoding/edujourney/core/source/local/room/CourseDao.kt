package com.dicoding.edujourney.core.source.local.room

import androidx.room.*
import com.dicoding.edujourney.core.source.local.entity.CourseEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CourseDao {
    @Query("SELECT * FROM course_table")
    fun getCourse(): Flow<List<CourseEntity>>

    @Query("SELECT * FROM course_table WHERE bought = 1")
    fun getEnrolledCourse() : Flow<List<CourseEntity>>

    @Query("SELECT * FROM course_table WHERE courseId = :id ")
    fun getDetail(id: Int) : Flow<CourseEntity>

    @Update
    fun updateEnroll(courseEntity: CourseEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCourse(course: List<CourseEntity>)

    @Query("SELECT * FROM course_table WHERE title LIKE :query")
    fun getSearch(query:String): Flow<List<CourseEntity>>
}