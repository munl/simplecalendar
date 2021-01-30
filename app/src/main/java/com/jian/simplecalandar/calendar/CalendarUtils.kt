package com.jian.simplecalandar.calendar

import com.jian.simplecalandar.calendar.data.CalendarDate
import com.jian.simplecalandar.calendar.data.Dog
import java.text.SimpleDateFormat
import java.util.*

object CalendarUtils {

    private const val DATE_FORMAT = "ccc MMM d"

    fun getCalendarWeek(doggos: List<Dog>): List<CalendarDate> {
        val calendarWeek: MutableList<CalendarDate> = arrayListOf()
        Calendar.getInstance().apply {
            set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY)
            doggos.forEach {
                calendarWeek.add(CalendarDate(Date(timeInMillis), it.url))
                add(Calendar.DAY_OF_WEEK, 1)
            }
        }
        return calendarWeek
    }

    fun getDateFormat(date: Date): String {
        return SimpleDateFormat(DATE_FORMAT).format(date)
    }

    fun Date.isToday(): Boolean {
        val today = Calendar.getInstance()
        val dateToCompare = Calendar.getInstance().apply {
            time = this@isToday
        }

        return today.get(Calendar.DAY_OF_WEEK) == dateToCompare.get(Calendar.DAY_OF_WEEK)
    }
}