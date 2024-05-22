package com.example.kotlin_project_theater.ui

/* @Composable
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
} */


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
/*

@Preview(name = "ConfirmPurchaseScreen")
@Composable
private fun PreviewConfirmPurchaseScreen() {
    ConfirmPurchaseScreen(onPurchaseClicked = {}, onPaymentMethodSelected = {})
}*/
