package com.example.kotlin_project_theater.data

object Utils {

    val cinemasList = listOf(
        Cinema(
            name = "AMC Empire 25",
            location = "234 W 42nd St"
        ),
        Cinema(
            name = "Regal Times Square",
            location = "247 W 42nd St"
        ),
        Cinema(
            name = "AMC Lincoln Square 13",
            location = "1998 Broadway"
        ),
        Cinema(
            name = "AMC 34th Street 14",
            location = "312 W 34th St"
        ),
    )
}

enum class CarBody(val type: String = "") {
    COUPE("coupe"),
    WAGON("wagon"),
    SEDAN("sedan"),
    SUV("SUV")
}
