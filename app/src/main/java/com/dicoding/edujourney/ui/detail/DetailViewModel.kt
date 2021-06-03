package com.dicoding.edujourney.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.edujourney.core.domain.usecase.CourseUseCase

class DetailViewModel(private val courseUseCase: CourseUseCase): ViewModel() {
    private val courseId = MutableLiveData<String>()

    fun setCourse(courseId: String){
        this.courseId.value = courseId
    }

    var detailCourse = Transformations.switchMap(courseId){
        courseId -> courseUseCase.getDetail(courseId).asLiveData()
    }

    fun setEnroll(){
        val course = detailCourse.value
        if(course != null){
            val newState = !course.isBought
            courseUseCase.setEnroll(course,newState)
        }
    }
}