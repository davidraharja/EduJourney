package com.dicoding.edujourney.ui.history

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.edujourney.core.domain.usecase.CourseUseCase

class HistoryViewModel(courseUseCase: CourseUseCase): ViewModel() {
    val history = courseUseCase.getEnrolledCourse().asLiveData()
}