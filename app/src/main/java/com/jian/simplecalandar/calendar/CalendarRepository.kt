package com.jian.simplecalandar.calendar

import androidx.lifecycle.MutableLiveData
import com.jian.simplecalandar.api.Api
import com.jian.simplecalandar.calendar.data.Dog
import com.jian.simplecalandar.calendar.data.DogResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class CalendarRepository @Inject constructor(val api: Api) {

    fun getDoggos(limit: Int): MutableLiveData<DogResponse> {
        val doggoLiveData: MutableLiveData<DogResponse> = MutableLiveData()
        api.getDoggos(limit).enqueue(object : Callback<List<Dog>> {
            override fun onFailure(call: Call<List<Dog>>, t: Throwable) {
                doggoLiveData.value = DogResponse(null, t as Exception)
            }

            override fun onResponse(call: Call<List<Dog>>, response: Response<List<Dog>>) {
                doggoLiveData.value = DogResponse(response.body(), null)

            }
        })
        return doggoLiveData
    }

}