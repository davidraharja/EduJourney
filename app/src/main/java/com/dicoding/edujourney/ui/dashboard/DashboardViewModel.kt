package com.dicoding.edujourney.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.edujourney.core.domain.usecase.CourseUseCase

class DashboardViewModel(courseUseCase: CourseUseCase) : ViewModel() {
    val enrolled = courseUseCase.getEnrolledCourse().asLiveData()


}