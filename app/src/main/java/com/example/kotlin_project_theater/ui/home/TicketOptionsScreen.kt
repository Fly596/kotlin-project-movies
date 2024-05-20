package com.example.kotlin_project_theater.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TicketOptionsScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        Text(text = "Select Ticket Type")
        TicketOptions()

        Button(onClick = { /*TODO*/ }) {
            Text("Confirm")
        }
    }
}

@Composable
fun TicketOptions() {
    Column() {
        TicketOptionItem("Adults: ")
        TicketOptionItem("Children: ")
    }
}

@Composable
fun TicketOptionItem(type: String) {
    var textFieldInput by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(vertical = 12.dp)) {

        Text(
            type, modifier = Modifier.padding(bottom = 6.dp),
            style = MaterialTheme.typography.titleMedium
        )

        TextField(
            value = textFieldInput,
            label = { Text("0") },
            onValueChange = { textFieldInput = it },
            singleLine = true
        )
    }
}

@Preview(name = "TicketOptionsScreen")
@Composable
private fun PreviewTicketOptionsScreen() {
    TicketOptionsScreen()
}