package com.jian.simplecalandar.calendar

import com.jian.simplecalandar.FragmentScoped
import com.jian.simplecalandar.calendar.view.CalendarFragment
import com.jian.simplecalandar.internal.ComponentApplication
import dagger.Component

@FragmentScoped
@Component(dependencies = [ComponentApplication::class], modules = [CalendarModule::class])
interface CalendarComponent {
    fun inject(calendarFragment: CalendarFragment)
}