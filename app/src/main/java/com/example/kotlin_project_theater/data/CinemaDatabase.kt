package com.example.kotlin_project_theater.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@TypeConverters(value = [DateConverter::class])
@Database(
    entities = [Ticket::class, Movie::class, Cinema::class, Showtime::class], version = 1
)
abstract class CinemaDatabase : RoomDatabase() {
    abstract fun cinemaDao(): CinemaDao

    companion object {

        // For Singleton..
        @Volatile
        var INSTANCE: CinemaDatabase? = null

        fun getInstance(context: Context): CinemaDatabase {
            return INSTANCE
                ?: synchronized(this) {
                    val instance =
                        Room.databaseBuilder(context, CinemaDatabase::class.java, "cinema_database")
                            .build()
                    INSTANCE = instance
                    return instance
                }
        }
    }
}