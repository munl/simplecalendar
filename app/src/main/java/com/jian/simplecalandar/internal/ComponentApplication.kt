package com.jian.simplecalandar.internal

import com.jian.simplecalandar.api.Api
import com.jian.simplecalandar.calendar.CalendarRepository
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, ApiModule::class])
interface ComponentApplication {

    fun getApi(): Api

    fun getCalendarRepository(): CalendarRepository
}