package com.dicoding.edujourney.core.source.remote

import com.dicoding.edujourney.core.utils.DummyCourse
import com.dicoding.edujourney.core.source.remote.network.ApiResponse
import com.dicoding.edujourney.core.source.remote.network.ApiService
import com.dicoding.edujourney.core.source.remote.response.CourseResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource(private val apiService: ApiService) {
    suspend fun getCourse(): Flow<ApiResponse<List<CourseResponse>>> {
        return flow {
            try {
                val response = DummyCourse.listData
                emit(ApiResponse.Success(response))
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }
}