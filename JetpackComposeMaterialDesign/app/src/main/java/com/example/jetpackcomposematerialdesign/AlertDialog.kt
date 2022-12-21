package com.example.jetpackcomposematerialdesign

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AlertDialogPage() {
    var defaultAlertDialogVisibility by remember { mutableStateOf(false) }
    var customAlertDialogVisibility by remember { mutableStateOf(false) }
    var textFieldDefaultValue by remember { mutableStateOf("") }
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { defaultAlertDialogVisibility = true }) {
            Text(text = "Default Alert Dialog")
        }
        if (defaultAlertDialogVisibility) {
            DefaultAlertDialogDesign(
                context = context,
                onDefaultAlertDialogClicked = { defaultAlertDialogVisibility = it })

        }

        Button(onClick = { customAlertDialogVisibility = true }) {
            Text(text = "Custom Alert Dialog")
        }
        if (customAlertDialogVisibility) {
            CustomAlertDialog(
                textFieldValue = textFieldDefaultValue,
                context = context,
                onCustomAlertDialogClicked = { customAlertDialogVisibility = it },
                onTextFieldChange = { textFieldDefaultValue = it  }
            )

        }
    }
}

@Composable
fun CustomAlertDialog(
    textFieldValue: String,
    context: Context,
    onCustomAlertDialogClicked: (Boolean) -> Unit,
    onTextFieldChange: (String) -> Unit
) {
    AlertDialog(
        onDismissRequest = { onCustomAlertDialogClicked(false) },
        title = { Text(text = "Alert Dialog Title", color = Color.White) },
        text = {
            TextField(
                value = textFieldValue,
                onValueChange = { onTextFieldChange(it) },
                label = { Text(text = "Data") })
        },
        confirmButton = {
            Text(
                text = "OK",
                color = Color.Red,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(all = 10.dp)
                    .clickable {
                        onCustomAlertDialogClicked(false)
                        Toast
                            .makeText(context, "OK clicked: $textFieldValue !", Toast.LENGTH_SHORT)
                            .show()
                        onTextFieldChange("")
                    })
        },
        dismissButton = {
            Text(
                text = "Cancel",
                color = Color.Red,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(all = 10.dp)
                    .clickable {
                        onCustomAlertDialogClicked(false)
                        Toast
                            .makeText(
                                context,
                                "Cancel clicked !",
                                Toast.LENGTH_SHORT
                            )
                            .show()
                        onTextFieldChange("")
                    })
        },
        backgroundColor = Color.LightGray
    )
}

@Composable
fun DefaultAlertDialogDesign(
    context: Context,
    onDefaultAlertDialogClicked: (Boolean) -> Unit
) {
    AlertDialog(
        onDismissRequest = { onDefaultAlertDialogClicked(false) },
        title = { Text(text = "Alert Dialog Title") },
        text = { Text(text = "Alert Dialog Message") },
        confirmButton = {
            Text(
                text = "OK",
                color = Color.Blue,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable {
                    onDefaultAlertDialogClicked(false)
                    Toast.makeText(context, "OK clicked !", Toast.LENGTH_SHORT).show()
                })
        },
        dismissButton = {
            Text(
                text = "Cancel",
                color = Color.Blue,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable {
                    onDefaultAlertDialogClicked(false)
                    Toast.makeText(context, "Cancel clicked !", Toast.LENGTH_SHORT).show()
                })
        }
    )
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun AlertDialogPagePreview() {
    AlertDialogPage()
}