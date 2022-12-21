package com.example.jetpackcomposewidgets

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SwitchWidget() {
    val context = LocalContext.current
    val switchStatus = remember { mutableStateOf(false) }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Switch(
            checked = switchStatus.value,
            onCheckedChange = { switchStatus.value = it },
            colors = SwitchDefaults.colors(
                checkedTrackColor = Color.Red,
                checkedThumbColor = Color.Yellow,
                uncheckedThumbColor = Color.Green,
                uncheckedTrackColor = Color.Blue
            )
        )
        Button(onClick = {
            Toast.makeText(
                context,
                switchStatus.value.toString(),
                Toast.LENGTH_SHORT
            ).show()
        }) {
            Text(text = "Show")
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SwitchWidgetPreview() {
    SwitchWidget()
}