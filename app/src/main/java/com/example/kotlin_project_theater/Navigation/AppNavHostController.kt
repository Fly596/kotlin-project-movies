package com.example.kotlin_project_theater.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.kotlin_project_theater.ui.home.GetTicketsScreen
import com.example.kotlin_project_theater.ui.home.HomeScreen
import kotlinx.serialization.Serializable

@Composable
fun AppNavHostController() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = HomeScreenA) {
        composable<HomeScreenA> {
            HomeScreen(
                onMovieClick = { movieId -> navController.navigate(GetTicketsScreenB(movieId)) }
            )
        }

        composable<GetTicketsScreenB> {
            val args = it.toRoute<GetTicketsScreenB>()

            GetTicketsScreen(args.selectedMovieId)
        }
    }
}

@Serializable object HomeScreenA

@Serializable data class GetTicketsScreenB(val selectedMovieId: Int)
