package com.example.kotlin_project_theater.ui.purchase

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.kotlin_project_theater.data.Cinema
import com.example.kotlin_project_theater.data.TableData
import com.example.kotlin_project_theater.ui.MovieTitle
import com.example.kotlin_project_theater.ui.theme.AppTheaterTheme
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class CinemasActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val movieId: Int = intent.getIntExtra("movieId", 1)
            val cinemasViewModel: CinemasViewModel =
                viewModel(modelClass = CinemasViewModel::class.java)

            val ticketsViewModel: TicketViewModel =
                viewModel(modelClass = TicketViewModel::class.java)

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
    viewModel: TicketViewModel = TicketViewModel(),
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
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                // Название театра.
                Text(text = cinema.name, style = MaterialTheme.typography.headlineMedium)

                // Адрес.
                Text(
                    text = "Address: ${cinema.location}",
                    style = MaterialTheme.typography.headlineSmall
                )
            }

            // Разделитель между секциями.
            HorizontalDivider(
                modifier = Modifier.padding(vertical = 8.dp),
                color = MaterialTheme.colorScheme.onSurface
            )

            // Выбор даты
            Text(text = "Date", style = MaterialTheme.typography.headlineSmall)
            val today = LocalDate.now()
            val dateChoices = listOf(
                today.plusDays(1.toLong()).format(DateTimeFormatter.ofPattern("MMMM.d")),
                today.plusDays(2.toLong()).format(DateTimeFormatter.ofPattern("MMMM.d")),
                today.plusDays(3.toLong()).format(DateTimeFormatter.ofPattern("MMMM.d"))
            )
            var selectedDate by remember { mutableStateOf("") }
            RadioButtonsRow(dateChoices, onValueSelected = { selectedDate = it })

            Spacer(modifier = Modifier.size(12.dp))

            // выбор времени
            Text(text = "Time", style = MaterialTheme.typography.headlineSmall)
            val timeChoices = listOf("12:00 PM", "03:00 PM", "09:00 PM")
            var selectedTime by remember { mutableStateOf("") }
            RadioButtonsRow(timeChoices, onValueSelected = { selectedTime = it })

            val context = LocalContext.current
            val intent = Intent(context, TicketActivity::class.java)
            Button(onClick = {
                viewModel.setTime(selectedTime)
                viewModel.setDate(selectedDate)

                context.startActivity(intent)
            }) {
                Text(text = "Confirm")
            }

        }
    }
}

@Composable
fun RadioButtonsRow(
    options: List<String>,
    onValueSelected: (String) -> Unit,
    title: String = "sad"
) {
    val selectedValue = remember { mutableStateOf("") }
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        options.forEach { option ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = option)
                RadioButton(
                    selected = selectedValue.value == option,
                    onClick = {
                        selectedValue.value = option
                        onValueSelected(option)
                    }
                )
            }

        }
    }
}

/* @Composable
fun PickDateRadioButtonsRow(date: String, onDatePick: (String) -> Unit) {

    Row {
        RadioButtonWithText(1, date, onClick = onDatePick)
        RadioButtonWithText(2, date, onClick = onDatePick)
        RadioButtonWithText(3, date, onClick = onDatePick)
    }
} */

// компонент радио батона с текстом слева.
/* @Composable
private fun RadioButtonWithText(
    index: Int,
    selectedDate: String,
    onClick: (String) -> Unit
) {
    val today = LocalDate.now()
    val dateIndexed = today.plusDays(index.toLong())
    val formated = dateIndexed.format(DateTimeFormatter.ofPattern("MM.d"))

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = formated)

        RadioButton(
            selected = selectedDate == formated.toString(),
            onClick = { selectedDate = formated }
        )
    }

} */

// строка с кнопками выбора времени.
@Composable
fun PickTimeButtonsRow() {
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

// кнопка для выбора времени
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