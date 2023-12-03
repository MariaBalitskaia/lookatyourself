package com.example.lookatyourself

import android.app.Application

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        shared = this
    }

    companion object {
        lateinit var shared: App private set
    }
}
