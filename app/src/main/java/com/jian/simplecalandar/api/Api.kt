package com.jian.simplecalandar.api

import com.jian.simplecalandar.calendar.data.Dog
import io.reactivex.rxjava3.core.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("images/search")
    fun getDoggos(@Query("limit") limit: Int): Call<List<Dog>>
}