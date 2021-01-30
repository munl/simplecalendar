package com.jian.simplecalandar.calendar

import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProviders
import dagger.Module
import dagger.Provides

@Module
class CalendarModule(
    private val view: CalendarContract.View,
    private val fragment: Fragment
) {

    @Provides
    fun providesLifecycleOwner(): LifecycleOwner {
        return fragment
    }

    @Provides
    fun providesCalendarView(): CalendarContract.View {
        return view
    }

    @Provides
    fun providesCalendarPresenter(calendarPresenter: CalendarPresenter): CalendarContract.Presenter {
        return calendarPresenter
    }

    @Provides
    fun providesCalendarViewModel(calendarRepository: CalendarRepository): CalendarViewModel {
        val calendarViewModel = ViewModelProviders.of(fragment).get(CalendarViewModel::class.java)
        calendarViewModel.calendarRepository = calendarRepository
        return calendarViewModel
    }
}