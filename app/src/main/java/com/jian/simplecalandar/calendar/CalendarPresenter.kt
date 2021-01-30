package com.jian.simplecalandar.calendar

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import javax.inject.Inject

class CalendarPresenter @Inject constructor(
    private val lifecycleOwner: LifecycleOwner,
    private val view: CalendarContract.View,
    private val calendarViewModel: CalendarViewModel
) : CalendarContract.Presenter {

    override fun getCalendarWithDoggos() {
        calendarViewModel.getDoggos(LIMIT).observe(lifecycleOwner, Observer {
            when {
                it.value != null -> view.renderCalendar(CalendarUtils.getCalendarWeek(it.value))
                it.exception != null -> view.showError(it.exception)
            }
        })
    }

    companion object {
        const val LIMIT = 7
    }
}