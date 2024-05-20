package com.example.kotlin_project_theater.data

import androidx.annotation.DrawableRes
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.Date

// Кинотеатр.
@Entity(tableName = "Cinema")
data class Cinema(
    @ColumnInfo(name = "cinemaId") @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val location: String
)

// фильмы.
@Entity(tableName = "Movies")
data class Movies(
    @ColumnInfo(name = "movieId") @PrimaryKey(autoGenerate = true) val movieId: Int = 0,
    val title: String,
    val year: Int,
    val length: Int,
    val description: String,
    @DrawableRes val poster: Int
)

@Entity(
    tableName = "Showtime",
    foreignKeys =
        [
            ForeignKey(
                entity = Cinema::class,
                parentColumns = ["cinemaId"],
                childColumns = ["cinemaId"]
            ),
            ForeignKey(
                entity = Movies::class,
                parentColumns = ["movieId"],
                childColumns = ["movieId"]
            )
        ]
)
data class Showtime(
    @ColumnInfo(name = "showtimeId") @PrimaryKey(autoGenerate = true) val showtimeId: Int = 0,
    val cinemaId: Int,
    val movieId: Int,
)

// Таблица билетов.
@Entity(
    tableName = "Ticket",
)
data class Ticket(
    @ColumnInfo(name = "ticketId") @PrimaryKey(autoGenerate = true) val ticketId: Int = 0,
    val cinemaName: String,
    val time: String,
    val date: Date,
    val seat: Int,
    val personName: String,
    val personEmail: String
)

/* @Entity(
    tableName = "Ticket",
    foreignKeys =
    [
        ForeignKey(
            entity = Showtime::class,
            parentColumns = ["showtimeId"],
            childColumns = ["showtimeId"],
            onDelete = ForeignKey.CASCADE
        )]
)
data class Ticket(
    @ColumnInfo(name = "ticketId") @PrimaryKey(autoGenerate = true) val ticketId: Int = 0,
    val showtimeId: Int,
    val date: Date,
    val seat: Int,
    val personName: String,
    val personPhone: String
) */
