package com.example.kotlin_project_theater.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
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
fun ConfirmPurchaseScreen(
    modifier: Modifier = Modifier,
    onPurchaseClicked: () -> Unit = {},
    onPaymentMethodSelected: (String) -> Unit = {}
) {
    var textFieldInput by remember { mutableStateOf("") }
    var selectedPaymentMethod by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        Text(
            "Contact info:",
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.primary
        )

        OutlinedTextField(
            value = textFieldInput,
            onValueChange = { textFieldInput = it },
            label = { Text("Email Address") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Text(
            "Payment info:",
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.primary
        )

        // Payment options
        val paymentMethods = listOf("Credit Card", "PayPal")
        paymentMethods.forEach { method ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .selectable(
                        selected = (method == selectedPaymentMethod),
                        onClick = {
                            selectedPaymentMethod = method
                            onPaymentMethodSelected(method)
                        }
                    )
            ) {
                RadioButton(
                    selected = (method == selectedPaymentMethod),
                    onClick = null // RadioButton click is handled by Row
                )
                Text(
                    text = method,
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }

        Spacer(modifier = Modifier.weight(1f)) // Pushes the button to the bottom

        Button(
            onClick = onPurchaseClicked,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            enabled = textFieldInput.isNotBlank() && selectedPaymentMethod.isNotBlank()
        ) {
            Text("Confirm Purchase")
        }
    }
}


/* @Composable
fun ConfirmPurchaseScreen(
    modifier: Modifier = Modifier
) {
    var textFieldInput by remember { mutableStateOf("") }

    Column(modifier = modifier.fillMaxSize()) {

        Text("Contact info: ")

        TextField(
            value = textFieldInput,
            label = { Text("email") },
            onValueChange = { textFieldInput = it },
            singleLine = true
        )

        Text("Payment info: ")

        Row() {
            RadioButton(selected = false, onClick = {  *//*TODO*//*  })
            Text("Credit Card")
        }
        Row() {
            RadioButton(selected = false, onClick = {  *//*TODO*//*  })
            Text("PayPal")
        }

        Button(onClick = {  *//*TODO*//*  }) {
            Text("Purchase")
        }
    }
} */

@Preview(name = "ConfirmPurchaseScreen")
@Composable
private fun PreviewConfirmPurchaseScreen() {
    ConfirmPurchaseScreen(onPurchaseClicked = {}, onPaymentMethodSelected = {})
}