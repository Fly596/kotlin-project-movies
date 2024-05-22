package com.example.kotlin_project_theater.ui.ticket

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.kotlin_project_theater.data.Cinema
import com.example.kotlin_project_theater.data.TableData
import com.example.kotlin_project_theater.ui.MovieTitle
import com.example.kotlin_project_theater.ui.RadioButtonsRow
import com.example.kotlin_project_theater.ui.home.HomeViewModel
import com.example.kotlin_project_theater.ui.theme.AppTheaterTheme

class TicketActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val movieId: Int = intent.getIntExtra("movieId", 1)
            val viewModel: HomeViewModel = viewModel(modelClass = HomeViewModel::class.java)
            val purchaseviewModel: PurchaseViewModel = viewModel(modelClass = PurchaseViewModel::class.java)

            purchaseviewModel.getMovieById(movieId)

            AppTheaterTheme {
                TicketScreen(purchaseviewModel)
            }
        }
    }
}

@Composable
fun TicketScreen(viewModel: PurchaseViewModel){
    val state = viewModel.state

    Column {

        MovieTitle(title = state.movie.title)

        HorizontalDivider(Modifier.padding(vertical = 8.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
        ) {
            items(TableData.cinemasList) { cinema->
                CinemaCard(cinema)
            }
        }
    }

}

@Composable
fun CinemaCard(
    cinema: Cinema,
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
                Text(text = cinema.name, style = MaterialTheme.typography.titleLarge)

                // Адрес.
                Text(text = cinema.location, style = MaterialTheme.typography.bodyMedium)
            }

            // Время показа.
            RadioButtonsRow(
            /*
            TODO: open new activity
             onClick = */ )
        }
    }
}