package com.example.kotlin_project_theater.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface CinemaDao {

    // CINEMA
    @Insert(onConflict = OnConflictStrategy.IGNORE) suspend fun insertCinema(cinema: Cinema)

    @Update(onConflict = OnConflictStrategy.REPLACE) suspend fun updateCinema(cinema: Cinema)

    @Delete suspend fun deleteCinema(cinema: Cinema)

    @Query("SELECT * FROM Cinema") fun getAllCinemas(): Flow<List<Cinema>>

    @Query("SELECT * FROM Cinema WHERE cinemaId = :cinemaId")
    fun getCinemaById(cinemaId: Int): Flow<Cinema>

    // Ticket.
    @Insert(onConflict = OnConflictStrategy.IGNORE) suspend fun insertTicket(ticket: Ticket)

    @Update(onConflict = OnConflictStrategy.REPLACE) suspend fun updateTicket(ticket: Ticket)

    @Delete suspend fun deleteTicket(ticket: Ticket)

    @Query("SELECT * FROM Ticket") fun getAllTickets(): Flow<List<Ticket>>

    @Query("SELECT * FROM Ticket WHERE ticketId = :ticketId")
    fun getTicketById(ticketId: Int): Flow<Ticket>

    // Movies
    @Insert(onConflict = OnConflictStrategy.IGNORE) suspend fun insertMovie(movie: Movies)

    @Update(onConflict = OnConflictStrategy.REPLACE) suspend fun updateMovie(movie: Movies)

    @Delete suspend fun deleteMovie(movie: Movies)

    @Query("SELECT * FROM Movies") fun getAllMovies(): Flow<List<Movies>>

    @Query("SELECT * FROM Movies WHERE movieId = :movieId")
    fun getMovieById(movieId: Int): Flow<Movies>

    // Showtime
    @Insert(onConflict = OnConflictStrategy.IGNORE) suspend fun insertShowtime(showtime: Showtime)

    @Update(onConflict = OnConflictStrategy.REPLACE) suspend fun updateShowtime(showtime: Showtime)

    @Delete suspend fun deleteShowtime(showtime: Showtime)

    @Query("SELECT * FROM Showtime") fun getAllShowtimes(): Flow<List<Showtime>>

    @Query("SELECT * FROM Showtime WHERE showtimeId = :showtimeId")
    fun getShowtimeById(showtimeId: Int): Flow<Showtime>
}
