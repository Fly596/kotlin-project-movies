package com.example.kotlin_project_theater.data

import androidx.annotation.DrawableRes
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "Ticket",
  foreignKeys = [
    ForeignKey(
      entity = Movie::class,
      parentColumns = ["id"],
      childColumns = ["movieId"],
      onDelete = ForeignKey.CASCADE
    )
  ])
data class Ticket(
  @ColumnInfo(name = "id")
  @PrimaryKey(autoGenerate = true)
  val id: Int = 0,
  val date: Date,
  val movieId: String,
  val seat: Int,
  val personName: String,
  val personPhone: String
);

@Entity(tableName = "Movie")
data class Movie(
  @ColumnInfo(name = "id")
  @PrimaryKey(autoGenerate = true)
  val id: Int = 0,
  val title: String,
  val description: String,
  @DrawableRes val poster: Int
);
