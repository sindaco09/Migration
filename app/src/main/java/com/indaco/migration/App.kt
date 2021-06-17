package com.indaco.migration

import android.app.Application

class App: Application() {

    companion object {
        lateinit var sInstance: App
    }

    override fun onCreate() {
        super.onCreate()
        sInstance = this
    }
}