package com.leonardo.myappcoinconverter

import android.app.Application
import android.app.Presentation
import com.leonardo.myappcoinconverter.data.di.DataModules
import com.leonardo.myappcoinconverter.domain.di.DomainModule
import com.leonardo.myappcoinconverter.presentation.di.PresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
        }

        DataModules.load()
        DomainModule.load()
        PresentationModule.load()
    }
}