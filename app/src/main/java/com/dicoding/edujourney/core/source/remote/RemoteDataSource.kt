package com.dicoding.edujourney.core.source.remote

import com.dicoding.edujourney.core.source.remote.network.ApiResponse
import com.dicoding.edujourney.core.source.remote.network.ApiService
import com.dicoding.edujourney.core.source.remote.response.CourseResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RemoteDataSource(private val apiService: ApiService) {
    suspend fun getCourse(): Flow<ApiResponse<List<CourseResponse>>> {
        return flow {
            try {
                val response =
                    if (response.id != 0) emit(ApiResponse.Success(response))
                    else emit(ApiResponse.Empty)
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }
}