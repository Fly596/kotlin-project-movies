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

  // Ticket.
  @Insert(onConflict = OnConflictStrategy.IGNORE)
  suspend fun insertTicket(ticket: Ticket)

  @Update(onConflict = OnConflictStrategy.REPLACE)
  suspend fun updateTicket(ticket: Ticket)

  @Delete
  suspend fun deleteTicket(ticket: Ticket)

  @Query("SELECT * FROM Ticket")
  fun getAllTickets(): Flow<List<Ticket>>

  @Query("SELECT * FROM Ticket WHERE id = :ticketId")
  fun getTicketById(ticketId: Int): Flow<Ticket>


  // Movie.
  @Insert(onConflict = OnConflictStrategy.IGNORE)
  suspend fun insertMovie(movie: Movie)

  @Update(onConflict = OnConflictStrategy.REPLACE)
  suspend fun updateMovie(movie: Movie)

  @Delete
  suspend fun deleteMovie(movie: Movie)

  @Query("SELECT * FROM Movie")
  fun getAllMovies(): Flow<List<Movie>>

  @Query("SELECT * FROM Movie WHERE id = :movieId")
  fun getMovieById(movieId: Int): Flow<Movie>

}