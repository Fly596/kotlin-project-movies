package com.example.kotlin_project_theater.data

class Repository(private val cinemaDao: CinemaDao) {
    fun getmovies() = cinemaDao.getAllMovies()
    fun gettickets() = cinemaDao.getAllTickets()
    fun getshowTimes() = cinemaDao.getAllShowtimes()
    fun getcinemas() = cinemaDao.getAllCinemas()

    fun getMovieById(movieId: Int) = cinemaDao.getMovieById(movieId)

    fun getTicketById(ticketId: Int) = cinemaDao.getTicketById(ticketId)

    suspend fun insertMovie(movie: Movies) = cinemaDao.insertMovie(movie)

    suspend fun insertTicket(ticket: Ticket) = cinemaDao.insertTicket(ticket)

    suspend fun insertCinema(cinema: Cinema) = cinemaDao.insertCinema(cinema)

    suspend fun insertShowtime(showtime: Showtime) = cinemaDao.insertShowtime(showtime)

    suspend fun deleteMovie(movie: Movies) = cinemaDao.deleteMovie(movie)

    suspend fun deleteTicket(ticket: Ticket) = cinemaDao.deleteTicket(ticket)

    suspend fun updateMovie(movie: Movies) = cinemaDao.updateMovie(movie)

    suspend fun updateTicket(ticket: Ticket) = cinemaDao.updateTicket(ticket)
}
