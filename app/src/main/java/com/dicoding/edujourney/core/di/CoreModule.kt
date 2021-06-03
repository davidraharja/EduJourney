package com.dicoding.edujourney.core.di

import androidx.room.Room
import com.dicoding.edujourney.core.domain.repository.ICourseRepository
import com.dicoding.edujourney.core.source.CourseRepository
import com.dicoding.edujourney.core.source.local.LocalDataSource
import com.dicoding.edujourney.core.source.local.room.CourseDatabase
import com.dicoding.edujourney.core.source.remote.RemoteDataSource
import com.dicoding.edujourney.core.source.remote.network.ApiService
import com.dicoding.edujourney.core.utils.AppExecutors
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val databaseModule = module {
    factory {
        get<CourseDatabase>().courseDao()
    }
    single {
        Room.databaseBuilder(
            androidContext(), CourseDatabase::class.java, "course_table"
        ).fallbackToDestructiveMigration().build()
    }
}


val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}

val repositoryModule = module {
    single { LocalDataSource(get()) }
    single { RemoteDataSource(get()) }
    factory { AppExecutors() }
    single<ICourseRepository> {
        CourseRepository(
            get(), get(), get()
        )
    }
}
