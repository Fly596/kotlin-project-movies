package com.example.kotlin_project_theater

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.kotlin_project_theater.Navigation.AppNavHostController
import com.example.kotlin_project_theater.ui.home.HomeViewModel
import com.example.kotlin_project_theater.ui.theme.AppTheaterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel = viewModel(modelClass = HomeViewModel::class.java)

            AppTheaterTheme {

                Surface(
                    modifier = Modifier.background(color = MaterialTheme.colorScheme.background)
                ) {
                    AppNavHostController()
                    //HomeScreen(onMovieClick = {})
                    // GetTicketsScreen()
                }
                // HomeScreen()
            }
        }
    }
}
