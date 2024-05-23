package com.example.kotlin_project_theater.ui.purchase

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.kotlin_project_theater.data.Cinema
import com.example.kotlin_project_theater.data.TableData
import com.example.kotlin_project_theater.ui.MovieTitle
import com.example.kotlin_project_theater.ui.home.HomeViewModel
import com.example.kotlin_project_theater.ui.theme.AppTheaterTheme
import org.w3c.dom.Text
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Locale

class CinemasActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val movieId: Int = intent.getIntExtra("movieId", 1)
            val homeViewModel: HomeViewModel = viewModel(modelClass = HomeViewModel::class.java)
            val cinemasViewModel: CinemasViewModel =
                viewModel(modelClass = CinemasViewModel::class.java)

            cinemasViewModel.getMovieById(movieId)

            AppTheaterTheme {
                Surface {
                    CinemasScreen(cinemasViewModel)
                }
            }
        }
    }
}

@Composable
fun CinemasScreen(viewModel: CinemasViewModel = CinemasViewModel()) {
    val state = viewModel.state

    Column {

        // Заголовок страницы.
        MovieTitle(title = state.movie.title)

        HorizontalDivider(Modifier.padding(vertical = 8.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
        ) {
            items(TableData.cinemasList) { cinema ->
                CinemaCard(state, cinema)
            }
        }
    }

}

@Composable
fun CinemaCard(
    state: PurchaseState,
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



            val calendar = Calendar.getInstance()

            val selectedDate = remember { mutableStateOf("") }

            calendar.getDisplayName( Calendar.MONTH,  Calendar.LONG, Locale.getDefault())
                ?.let { Text(text = "Date",style = MaterialTheme.typography.titleMedium) }
            DatePicker()

            RadioButtonsRow()

        }
    }
}

@Composable
fun DatePicker() {
    val selectedDate = remember { mutableStateOf("") }

    Row{
        RadioButtonWithText(1, selectedDate)
        RadioButtonWithText(2, selectedDate)
        RadioButtonWithText(3, selectedDate)
    }


}



//     Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
//
//         Row(
// verticalAlignment = Alignment.CenterVertically
//         ) {
//             val date = LocalDate.now()
//             //val date: String = "${calendar.get(Calendar.DAY_OF_MONTH) + 1}"
//             //Text(text = date)
//
//             RadioButton(
//                 selected = selectedDate.value == date,
//                 onClick = { selectedDate.value = date }
//             )
//
//         }
//
//         Row(
//             verticalAlignment = Alignment.CenterVertically
//         )  {
//
//
//
//             RadioButton(
//                 selected = selectedDate.value == date,
//                 onClick = { selectedDate.value = date }
//             )
//
//         }






@Composable
private fun RadioButtonWithText(
    index: Int,
    selectedDate: MutableState<String>
) {
    val today = LocalDate.now()
    val dateIndexed = today.plusDays(index.toLong())
    val formated = dateIndexed.format(DateTimeFormatter.ofPattern("MM.d"))

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = formated)

        RadioButton(
            selected = selectedDate.value == formated.toString(),
            onClick = { selectedDate.value = formated }
        )

    }
}


@Composable
fun RadioButtonsRow() {

    val timeChoices = listOf("12:00 PM", "03:00 PM", "09:00 PM")

    Column {
        Text(text = "Available time", style = MaterialTheme.typography.titleMedium)

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            timeChoices.forEach { timeOp ->
                TimeOptionButton(time = timeOp)
            }
        }
    }
}

@Composable
fun TimeOptionButton(time: String) {
    val context = LocalContext.current
    val intent = Intent(context, TicketActivity::class.java)


    OutlinedButton(
        onClick = {
            // передача id выбранного фильма.
            intent.putExtra("time", time)

            // запуск активити.
            context.startActivity(intent)
        },
        shape = RoundedCornerShape(4.dp)
    ) {
        Text(text = time)
    }
}

@Preview
@Composable
private fun PreviewTicketScreen() {
    AppTheaterTheme {
        CinemasScreen()
    }
}