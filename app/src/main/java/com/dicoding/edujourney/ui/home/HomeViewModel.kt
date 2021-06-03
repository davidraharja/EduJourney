package com.dicoding.edujourney.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.edujourney.core.domain.usecase.CourseUseCase

class HomeViewModel(courseUseCase: CourseUseCase) : ViewModel() {
    val course = courseUseCase.getCourse().asLiveData()
}