package com.example.kotlin_project_theater.ui.purchase

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin_project_theater.data.Graph
import com.example.kotlin_project_theater.data.Repository
import com.example.kotlin_project_theater.data.Ticket
import kotlinx.coroutines.launch
import java.util.Date

class TicketViewModel(private val repository: Repository = Graph.repository) : ViewModel() {

    var state by mutableStateOf(TicketState())
        private set

    fun addTicket(ticket: Ticket) {
        viewModelScope.launch {
            repository.insertTicket(ticket)
        }
    }

    fun setTime(time: String){
        viewModelScope.launch {
            state = state.copy(time = time)
        }
    }

}

data class TicketState(
    val cinemaName: String = "",
    val time: String = "",
    val date: Date = Date(),
    val seat: Int = 0,
    val personEmail: String = ""


)