package com.example.kotlin_project_theater.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/*
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

        Button(onClick = {  *//*TODO*//*  }) {
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
} */

// Выбор типа билета (взрослый/детский)
@Composable
fun TicketOptionsScreen(
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Select Ticket Type",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.Start)
            )
            Spacer(modifier = Modifier.height(24.dp))
            TicketOptions()
            Spacer(modifier = Modifier.height(32.dp))
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text("Confirm")
            }
        }
    }
}

@Composable
fun TicketOptions() {
    Column {
        TicketOptionItem("Adults: ")
        TicketOptionItem("Children: ")
    }
}

@Composable
fun TicketOptionItem(type: String) {
    var textFieldInput by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(vertical = 12.dp)) {
        Text(
            type,
            modifier = Modifier.padding(bottom = 6.dp),
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.Medium
        )
        OutlinedTextField(
            value = textFieldInput,
            onValueChange = { textFieldInput = it },
            label = { Text("Enter number") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
    }
}


@Preview(name = "TicketOptionsScreen")
@Composable
private fun PreviewTicketOptionsScreen() {
    TicketOptionsScreen()
}