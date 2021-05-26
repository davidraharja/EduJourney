package com.dicoding.edujourney.di

import com.dicoding.edujourney.ui.dashboard.DashboardViewModel
import com.dicoding.edujourney.ui.detail.DetailViewModel
import com.dicoding.edujourney.ui.home.HomeViewModel
import com.dicoding.edujourney.ui.profile.ProfileViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

import com.dicoding.edujourney.ui.dashboard.DashboardViewModel
import com.dicoding.edujourney.ui.home.HomeViewModel
import com.dicoding.edujourney.ui.notifications.NotificationsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module{
    viewModel{ DashboardViewModel()}
    viewModel{ HomeViewModel() }
    viewModel { NotificationsViewModel() }
}