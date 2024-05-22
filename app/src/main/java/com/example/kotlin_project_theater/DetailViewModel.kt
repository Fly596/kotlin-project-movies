package com.example.kotlin_project_theater

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin_project_theater.data.Cinema
import com.example.kotlin_project_theater.data.Graph
import com.example.kotlin_project_theater.data.Repository
import com.example.kotlin_project_theater.data.Ticket
import kotlinx.coroutines.launch
import java.util.Date

class DetailViewModel
constructor(
    private val movieId: Int,
    private val repository: Repository = Graph.repository
) : ViewModel() {

    var state by mutableStateOf(DetailState())
        private set

    fun onTimeChange(newVal: String) {
        state = state.copy(time = newVal)
    }

/*     fun onCinemaChange(newVal: Cinema) {
        state = state.copy(selectedCinema = newVal)
    } */

/*     fun addCinema() {
        viewModelScope.launch {
            TableData.cinemasList.forEach { cinema ->
                repository.insertCinema(cinema)
            }
        }
    } */

    fun addTicket() {
        viewModelScope.launch {
            repository.insertTicket(
                Ticket(
                    cinemaName = state.selectedCinemaName,
                    time = state.time,
                    date = state.date,
                    seat = state.seat,
                    personEmail = state.personEmail
                )
            )
        }
    }


}

data class DetailState(
    val cinemaList: List<Cinema> = emptyList(),
    val selectedCinema: Cinema? = null,
    val selectedCinemaName: String = "",//?
    val movieName: String = "",//?
    val time: String = "",
    val date: Date = Date(),
    val seat: Int = 0,
    val personName: String = "",
    val personEmail: String = ""

)