package com.example.kotlin_project_theater.data

object Utils {

    val cinemasList = listOf(Cinema(name = "nameq", location = "malholland drive"))
}

enum class CarBody(val type: String = "") {
    COUPE("coupe"),
    WAGON("wagon"),
    SEDAN("sedan"),
    SUV("SUV")
}
