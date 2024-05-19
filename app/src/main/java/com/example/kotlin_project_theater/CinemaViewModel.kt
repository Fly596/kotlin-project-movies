package com.example.kotlin_project_theater

import androidx.lifecycle.ViewModel
import com.example.kotlin_project_theater.data.Graph
import com.example.kotlin_project_theater.data.Repository

class CinemaViewModel(
    private val repository: Repository = Graph.repository
) : ViewModel() { }
