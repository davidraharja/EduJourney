package com.dicoding.edujourney.core.source.remote.network

import com.dicoding.edujourney.core.source.remote.response.CourseResponse

interface ApiService {
    //retrofit
    suspend fun getCourse(): CourseResponse
}