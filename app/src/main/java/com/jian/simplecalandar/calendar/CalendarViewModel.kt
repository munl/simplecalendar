package com.jian.simplecalandar.calendar

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.jian.simplecalandar.calendar.data.DogResponse

class CalendarViewModel : ViewModel() {
    lateinit var calendarRepository: CalendarRepository

    fun getDoggos(limit: Int): LiveData<DogResponse> {
        return calendarRepository.getDoggos(limit)
    }
}