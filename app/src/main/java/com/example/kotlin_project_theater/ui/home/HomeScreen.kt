package com.example.kotlin_project_theater.ui.home

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.kotlin_project_theater.R
/*
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors =
                TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                ),
                title = { Text("Home Screen") },
                actions = {
                    IconButton(onClick = {  *//*TODO*//*  }) {
                        Icon(
                            painter = painterResource(R.drawable.icon_tickets_fill),
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    }
                })
        },
    ) { innerPadding ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            items(4) { MovieCardItem() }
        }
    }
}

@Composable
fun MovieCardItem(modifier: Modifier = Modifier) {
    ElevatedCard(
        colors =
        CardDefaults.elevatedCardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
        ),
    ) {
        Column {
            Image(
                painter = painterResource(R.drawable.the_neon_demon_2016),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(250.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
            ShortDescription(
                name = "The Neon Demon",
                year = "2016",
                length = "1 HR 44 MIN",
                modifier = Modifier.padding(top = 8.dp, start = 8.dp, end = 8.dp)
            )
            Button(
                onClick = {  *//*TODO*//*  },
                modifier = Modifier.padding(8.dp),
            ) {
                Text(text = "Get Tickets")
            }
        }
    }
}

@Composable
fun ShortDescription(name: String, length: String, year: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = name,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(text = length, style = MaterialTheme.typography.bodySmall)
        Text(text = "Released $year", style = MaterialTheme.typography.bodySmall)
    }
} */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Home Screen", style = MaterialTheme.typography.headlineSmall) },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                ),
                actions = {
                    IconButton(onClick = { /* Handle ticket icon action */ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.the_neon_demon_2016),
                            contentDescription = "Tickets",
                            tint = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    }
                }
            )
        },
        modifier = modifier
    ) { innerPadding ->
        LazyVerticalStaggeredGrid (
            columns = StaggeredGridCells.Adaptive(minSize = 128.dp ),
            contentPadding = PaddingValues(all = 16.dp),
            //horizontalArrangement = Arrangement.spacedBy(16.dp),
            //verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            items(4) { index ->
                MovieCardItem(movie = moviesList[index])
            }
        }
    }
}

@Composable
fun MovieCardItem(movie: Movie, modifier: Modifier = Modifier) {
    ElevatedCard(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
        ,
        colors = CardDefaults.elevatedCardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
            contentColor = MaterialTheme.colorScheme.onSurfaceVariant
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = movie.imageRes),
                contentDescription = movie.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(0.75f)
                    .clip(MaterialTheme.shapes.medium)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = movie.title,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Text(
                text = "${movie.length} | Released ${movie.year}",
                style = MaterialTheme.typography.bodySmall
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { /* Handle get tickets action */ },
                modifier = Modifier.fillMaxWidth(),
                shape = MaterialTheme.shapes.medium
            ) {
                Text("Get Tickets")
            }
        }
    }
}

// Assuming you have a Movie data class and a list of movies
data class Movie(val title: String, val year: String, val length: String, val imageRes: Int)

val moviesList = listOf(
    Movie("The Neon Demon", "2016", "1 HR 44 MIN", R.drawable.the_neon_demon_2016),
    Movie("The Shawshank Redemption", "1994", "2 HR 22 MIN", R.drawable.the_shining_1980),
    Movie("The Godfather", "1972", "2 HR 55 MIN", R.drawable.the_revenant_2015),
    Movie("The Godfather: Part II", "1974", "3 HR 22 MIN", R.drawable.the_arrival_of_a_train_1896),
    // Populate with actual movie data and resource IDs
)


@Preview(
    name = "HomeScreen",
    device = "id:pixel_8", showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
    showBackground = true,
)
@Composable
private fun PreviewHomeScreen() {
    HomeScreen()
}
