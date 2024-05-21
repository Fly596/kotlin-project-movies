package com.example.kotlin_project_theater.ui.home

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
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: Repository = Graph.repository
) : ViewModel() {

    // region renew
    var state by mutableStateOf(HomeState())
        private set

    init {
        getMovies()
    }

    private fun getMovies() {
        viewModelScope.launch {
            repository.moviesVal.collectLatest {
                state = state.copy(movies = it)
            }
        }
    }


    // endregion

    private fun getCinemas() {
        viewModelScope.launch {
            repository.getcinemas().collectLatest {
                state = state.copy(cinemas = it)
            }
        }
    }

    fun getMovieById(movieId: Int) {
        viewModelScope.launch {
            repository.getMovieById(movieId).collectLatest {
                state = state.copy(selectedMovie = it)
            }
        }
    }
    /*     val movies = repository.movies.collectLatest {
            state = state.copy(movies = it)
        } */


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

data class HomeState(
    val movies: List<Movies> = emptyList(),
    val cinemas: List<Cinema> = emptyList(),
    val showTimes: List<Showtime> = emptyList(),
    val tickets: List<Ticket> = emptyList(),
    val selectedMovie: Movies? = null

)
