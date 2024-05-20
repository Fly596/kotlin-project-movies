package com.example.kotlin_project_theater

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin_project_theater.data.Cinema
import com.example.kotlin_project_theater.data.Graph
import com.example.kotlin_project_theater.data.Movies
import com.example.kotlin_project_theater.data.Repository
import com.example.kotlin_project_theater.data.Showtime
import com.example.kotlin_project_theater.data.TableData
import com.example.kotlin_project_theater.data.Ticket
import kotlinx.coroutines.launch

class CinemaViewModel(private val repository: Repository = Graph.repository) : ViewModel() {

    var state by mutableStateOf(CinemaAppState())
        private set

    val cinemas = repository.cinemas
    val movies = repository.movies
    val showTimes = repository.showTimes
    val tickets = repository.tickets

    fun addMovie() {
        viewModelScope.launch {
            TableData.moviesList.forEach { movie -> repository.insertMovie(movie) }
        }
    }

    fun convertMinToHoursMin(minutes: Int): String {
        val hours = minutes / 60
        val mins = minutes % 60

        return "$hours H $mins MIN"
    }
}

data class CinemaAppState(
    val movies: List<Movies> = emptyList(),
    val cinemas: List<Cinema> = emptyList(),
    val showTimes: List<Showtime> = emptyList(),
    val tickets: List<Ticket> = emptyList()
)
