package com.example.kotlin_project_theater.ui.home

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin_project_theater.data.Graph
import com.example.kotlin_project_theater.data.Movies
import com.example.kotlin_project_theater.data.Repository
import com.example.kotlin_project_theater.data.TableData
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: Repository = Graph.repository) : ViewModel() {

    var state by mutableStateOf(HomeStateN())
        private set

    init {
        getMovies()
    }


    fun addMovie() {
        viewModelScope.launch {
            TableData.moviesList.forEach { movie -> repository.insertMovie(movie) }
        }
    }

    private fun getMovies() {
        viewModelScope.launch {
            repository.getMovies().collectLatest {
                state = state.copy(movies = it)
            }
        }
    }

    fun convertMinToHoursMin(minutes: Int): String {
        val hours = minutes / 60
        val mins = minutes % 60

        return "$hours H $mins MIN"
    }
}

data class HomeStateN(
    val movies: List<Movies> = emptyList(),
)

/* data class HomeState(
    val movies: List<Movies> = emptyList(),
    val cinemas: List<Cinema> = emptyList(),
    val showTimes: List<Showtime> = emptyList(),
    val tickets: List<Ticket> = emptyList(),
    val selectedMovie: Movies? = null

) */
