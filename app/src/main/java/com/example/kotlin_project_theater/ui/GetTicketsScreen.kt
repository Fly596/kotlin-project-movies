package com.example.kotlin_project_theater.ui

import android.content.res.Configuration
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kotlin_project_theater.R

@Composable
fun GetTicketsScreen(movieId: Int) {
//   val viewModel = viewModel(modelClass = CinemaViewModel::class.java)

    //val state = viewModel.state
    //val moviesList = viewModel.getMovieById(movieId)


    Column {

        //MovieTitle(title = moviesList[movieId].title)

        HorizontalDivider(Modifier.padding(vertical = 8.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
        ) {
            items(4) {
                CinemaCard()
            }
        }
    }

}

@Composable
fun MovieTitle(
    @DrawableRes image: Int = R.drawable.the_neon_demon_2016,
    title: String = "movie Title",
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(shape = androidx.compose.foundation.shape.CircleShape)
                .size(64.dp)
        )
        Text(text = title, style = MaterialTheme.typography.headlineLarge)

    }
}


@Composable
fun CinemaCard(
    cinemaName: String = "CinemaName",
    cinemaAddress: String = "Address",
    modifier: Modifier = Modifier
) {
    Card(modifier = modifier.padding(vertical = 16.dp)) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth()

        ) {

            // Название и адрес кинотеатра.
            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                // Название театра.
                Text(text = cinemaName, style = MaterialTheme.typography.titleLarge)

                // Адрес.
                Text(text = cinemaAddress, style = MaterialTheme.typography.bodyMedium)
            }

            // Время показа.
            RadioButtonsRow()
        }
    }
}

@Composable
fun RadioButtonsRow(onClick: () -> Unit = {}) {
    val timeChoices = listOf("12:00 PM", "03:00 PM", "09:00 PM")

    Column {
        Text(text = "Available time", style = MaterialTheme.typography.titleMedium)

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            timeChoices.forEach { timeOp ->
                TimeOptionButton(time = timeOp, onClick = onClick)
            }
        }
    }
}

@Composable
fun TimeOptionButton(time: String = "12:00 PM", onClick: () -> Unit = {}) {
    // TODO: add onClick listener to start new activity

    OutlinedButton(
        onClick = { onClick },
        shape = RoundedCornerShape(4.dp)
    ) {
        Text(text = time)
    }
}

@Preview(
    name = "HomeScreen",
    device = "id:pixel_8", showSystemUi = true, backgroundColor = 0xFFFFFFFF,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
    showBackground = true,
)
@Composable
private fun PreviewGetTicketsScreen() {
    //GetTicketsScreen(movieId = 2)
}
