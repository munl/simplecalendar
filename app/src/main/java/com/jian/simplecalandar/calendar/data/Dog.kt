package com.jian.simplecalandar.calendar.data


data class DogResponse(val value: List<Dog>?, val exception: Exception?)

data class Dog(
    val id: String,
    val url: String,
    val width: Int,
    val Height: Int,
    val breeds: List<Breed>
)
