package com.example.kotlin_project_theater.data

class Repository(
  private val cinemaDao: CinemaDao

) {
  val movies = cinemaDao.getAllMovies()
  val tickets = cinemaDao.getAllTickets()

  fun getMovieById(movieId: Int) = cinemaDao.getMovieById(movieId)

  fun getTicketById(ticketId: Int) = cinemaDao.getTicketById(ticketId)

  suspend fun insertMovie(movie: Movie) = cinemaDao.insertMovie(movie)

  suspend fun insertTicket(ticket: Ticket) = cinemaDao.insertTicket(ticket)

  suspend fun deleteMovie(movie: Movie) = cinemaDao.deleteMovie(movie)

  suspend fun deleteTicket(ticket: Ticket) = cinemaDao.deleteTicket(ticket)

  suspend fun updateMovie(movie: Movie) = cinemaDao.updateMovie(movie)

  suspend fun updateTicket(ticket: Ticket) = cinemaDao.updateTicket(ticket)


}