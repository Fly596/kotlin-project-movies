package com.example.kotlin_project_theater.ui.ticket

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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kotlin_project_theater.ui.theme.AppTheaterTheme

class TicketActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheaterTheme {
                Surface {

                }
            }
        }
    }
}

// Выбор типа билета (взрослый/детский)
@Composable
fun TicketScreen(
    modifier: Modifier = Modifier,
    onPurchaseClicked: () -> Unit = {},
    onPaymentMethodSelected: (String) -> Unit = {}
) {
    var textFieldInput by remember { mutableStateOf("") }
    var selectedPaymentMethod by remember { mutableStateOf("") }

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
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
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
            }


            Spacer(modifier = Modifier.weight(1f)) // Pushes the button to the bottom


            Button(
                onClick = { onPurchaseClicked },
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
        TicketOptionItem("Number of adults")
        TicketOptionItem("Number of children")
        TicketOptionItem("Email address")
    }
}

@Composable
fun TicketOptionItem(label: String) {
    var textFieldInput by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(vertical = 8.dp)) {
/*         Text(
            type,
            modifier = Modifier.padding(bottom = 3.dp),
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.Medium
        ) */
        OutlinedTextField(
            value = textFieldInput,
            onValueChange = { textFieldInput = it },
            label = { Text(label) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
    }
}


@Preview(name = "TicketOptionsScreen")
@Composable
private fun PreviewTicketOptionsScreen() {
    AppTheaterTheme {
        Surface {
            TicketScreen()
        }
    }
}
