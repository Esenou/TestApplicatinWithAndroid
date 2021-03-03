package com.example.mytestapplication

import android.app.Application
import com.example.mytestapplication.data.ForumService
import com.example.mytestapplication.data.Network


class StartApplication : Application() {
    private val BASE_URL = "https://official-joke-api.appspot.com"

    companion object {
        @Volatile
        lateinit var service: ForumService

    }

    override fun onCreate() {
        super.onCreate()
        service = Network.initService(BASE_URL)
    }
}