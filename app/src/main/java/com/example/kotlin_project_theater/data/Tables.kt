package com.example.kotlin_project_theater.data

import androidx.annotation.DrawableRes
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

// фильмы.
@Entity(tableName = "Movies")
data class Movies(
    @ColumnInfo(name = "movieId")
    @PrimaryKey(autoGenerate = true)
    val movieId: Int = 0,
    val title: String,
    val year: Int,
    val length: Int,
    val description: String,
    @DrawableRes
    val poster: Int
)

// Билеты.
@Entity(tableName = "Ticket")
data class Ticket(
    @ColumnInfo(name = "ticketId")
    @PrimaryKey(autoGenerate = true)
    val ticketId: Int = 0,
    val cinemaName: String,
    val time: String,
    val date: Date,
    val seat: Int,
    val personEmail: String
)