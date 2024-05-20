package com.example.kotlin_project_theater.ui.home

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kotlin_project_theater.CinemaViewModel
import com.example.kotlin_project_theater.R
import com.example.kotlin_project_theater.data.Movies
import com.example.kotlin_project_theater.data.TableData.moviesList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(onMovieClick: (Int) -> Unit, modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Now Playing", style = MaterialTheme.typography.headlineMedium) },
                colors =
                    TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                    ),
                actions = {

                    // Кнопка для просмотра купленных билетов.
                    IconButton(
                        onClick = { /* TODO: Handle ticket icon action */ },
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.icon_tickets_fill),
                            contentDescription = "Tickets",
                            tint = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    }
                }
            )
        },
        modifier = modifier
    ) { innerPadding ->

        // Список прокатных фильмов.
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Adaptive(minSize = 128.dp),
            contentPadding = PaddingValues(all = 16.dp),
            modifier = Modifier.padding(innerPadding).fillMaxSize()
        ) {
            // TODO:
            items(4) { index -> MovieCardItem(movie = moviesList[index], onMovieClick) }
        }
    }
}

// Карточка фильма.
@Composable
fun MovieCardItem(movie: Movies, onClick: (Int) -> Unit, modifier: Modifier = Modifier) {
    val viewModel = CinemaViewModel()

    ElevatedCard(
        modifier = modifier.fillMaxWidth().padding(8.dp),
        colors =
            CardDefaults.elevatedCardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant,
                contentColor = MaterialTheme.colorScheme.onSurfaceVariant
            ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {

            // Постер
            Image(
                painter = painterResource(id = movie.poster),
                contentDescription = movie.title,
                contentScale = ContentScale.Crop,
                modifier =
                    Modifier.fillMaxWidth().aspectRatio(0.75f).clip(MaterialTheme.shapes.medium)
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Краткая инфа о фильме: название и длина.
            Text(
                text = movie.title,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Text(
                text = "${viewModel.convertMinToHoursMin(movie.length)} | Released ${movie.year}",
                style = MaterialTheme.typography.bodySmall
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Кнопка для выбора фильма.
            Button(
                onClick = { onClick(movie.movieId) },
                modifier = Modifier.fillMaxWidth(),
                shape = MaterialTheme.shapes.medium
            ) {
                Text("Get Tickets")
            }
        }
    }
}

@Preview(
    name = "HomeScreen",
    device = "id:pixel_8",
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
    showBackground = true,
)
@Composable
private fun PreviewHomeScreen() {
    HomeScreen(onMovieClick = {})
}
