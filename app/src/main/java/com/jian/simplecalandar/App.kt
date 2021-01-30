package com.jian.simplecalandar

import android.app.Application
import com.jian.simplecalandar.internal.ApiModule
import com.jian.simplecalandar.internal.ApplicationModule
import com.jian.simplecalandar.internal.ComponentApplication
import com.jian.simplecalandar.internal.DaggerComponentApplication

class App : Application() {

    lateinit var applicationComponent: ComponentApplication

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerComponentApplication.builder()
            .applicationModule(ApplicationModule(this))
            .apiModule(ApiModule())
            .build()
    }
}