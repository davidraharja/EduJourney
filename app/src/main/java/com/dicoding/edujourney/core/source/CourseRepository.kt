package com.dicoding.edujourney.core.source

import com.dicoding.edujourney.core.domain.model.Course
import com.dicoding.edujourney.core.domain.repository.ICourseRepository
import com.dicoding.edujourney.core.source.local.LocalDataSource
import com.dicoding.edujourney.core.source.remote.RemoteDataSource
import com.dicoding.edujourney.core.source.remote.network.ApiResponse
import com.dicoding.edujourney.core.source.remote.response.CourseResponse
import com.dicoding.edujourney.core.utils.AppExecutors
import com.dicoding.edujourney.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CourseRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : ICourseRepository {
    override fun getCourse(): Flow<Resource<List<Course>>> {
        return object : NetworkBoundResource<List<Course>, List<CourseResponse>>() {
            override fun loadFromDB(): Flow<List<Course>> {
                return localDataSource.getCourse().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Course>?): Boolean =
                data.isNullOrEmpty()


            override suspend fun createCall(): Flow<ApiResponse<List<CourseResponse>>> =
                remoteDataSource.getCourse()


            override suspend fun saveCallResult(data: List<CourseResponse>) {
                val courseList = DataMapper.mapCourseResponseToEntities(data)
                localDataSource.insertCourse(courseList)
            }

        }.asFlow()
    }

    override fun getDetail(id: Int): Flow<Course> {
        return localDataSource.getDetail(id).map {
            DataMapper.mapEntityToDomain(it)
        }
    }

    override fun getEnrolledCourse(): Flow<List<Course>> {
        return localDataSource.getEnrolledCourse().map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun getSearch(query: String): Flow<List<Course>> {
        return localDataSource.getSearch(query).map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun setEnroll(course: Course, bought: Boolean) {
        val enroll = DataMapper.mapDomainToEntity(course)
        appExecutors.diskIO().execute{
            localDataSource.setEnroll(enroll,bought)
        }
    }
}