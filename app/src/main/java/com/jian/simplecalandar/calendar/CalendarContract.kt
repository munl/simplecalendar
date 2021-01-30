package com.jian.simplecalandar.calendar

import com.jian.simplecalandar.calendar.data.CalendarDate

interface CalendarContract {
    interface View {
        fun showLoading()
        fun renderCalendar(calendarWeek: List<CalendarDate>)
        fun showError(exception: Exception)
    }

    interface Presenter {
        fun getCalendarWithDoggos()
    }
}