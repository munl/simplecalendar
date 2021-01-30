package com.jian.simplecalandar.internal

import android.content.Context
import com.jian.simplecalandar.App
import com.jian.simplecalandar.api.Api
import com.jian.simplecalandar.calendar.CalendarRepository
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class ApplicationModule(val app: App) {

    @Provides
    @Singleton
    @Named("app")
    fun provideApplicationContext(): Context {
        return app
    }

    @Provides
    @Singleton
    fun providesCalendarRepository(api: Api): CalendarRepository {
        return CalendarRepository(api)
    }

}