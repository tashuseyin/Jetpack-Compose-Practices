package com.example.jetpackcomposewidgets

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CheckBoxWidget() {
    val context = LocalContext.current
    val checkBoxStatus = remember { mutableStateOf(false) }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            Checkbox(
                checked = checkBoxStatus.value,
                onCheckedChange = { checkBoxStatus.value = it },
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Blue,
                    uncheckedColor = Color.DarkGray
                )
            )
            Text(text = "Jetpack Compose", modifier = Modifier.padding(10.dp))
        }
        Button(onClick = {
            Toast.makeText(
                context,
                checkBoxStatus.value.toString(),
                Toast.LENGTH_SHORT
            ).show()
        }) {
            Text(text = "Show")
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CheckBoxWidgetPreview() {
    CheckBoxWidget()
}
