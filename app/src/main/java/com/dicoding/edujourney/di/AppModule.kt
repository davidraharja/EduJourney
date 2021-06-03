package com.dicoding.edujourney.di

import com.dicoding.edujourney.core.domain.usecase.CourseInteractor
import com.dicoding.edujourney.core.domain.usecase.CourseUseCase
import com.dicoding.edujourney.ui.dashboard.DashboardViewModel
import com.dicoding.edujourney.ui.home.HomeViewModel
import com.dicoding.edujourney.ui.notifications.ProfileViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<CourseUseCase>{
        CourseInteractor(get())
    }
}
val viewModelModule = module{
    viewModel { DashboardViewModel() }
    viewModel { HomeViewModel() }
    viewModel { ProfileViewModel() }

}