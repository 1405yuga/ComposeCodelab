package com.example.marsphoto

import android.app.Application
import com.example.marsphoto.data.AppContainer
import com.example.marsphoto.data.DefaultContainer

class MarsPhotoApplication : Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultContainer()
    }
}