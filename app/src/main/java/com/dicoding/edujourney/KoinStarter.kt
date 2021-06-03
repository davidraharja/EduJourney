package com.dicoding.edujourney

import android.app.Application
import com.dicoding.edujourney.core.di.databaseModule
import com.dicoding.edujourney.core.di.repositoryModule
import com.dicoding.edujourney.di.useCaseModule
import com.dicoding.edujourney.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class KoinStarter: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidLogger(Level.NONE)
            androidContext(this@KoinStarter)
            modules(
                listOf(
                    databaseModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
//                , networkModule
                )
            )
        }
    }
}