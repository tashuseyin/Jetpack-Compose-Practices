package com.example.jetpackcomposewidgets

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FloatingActionButtonPage() {
    val context = LocalContext.current
    Scaffold(
        floatingActionButton = {
            Column {
                FloatingActionButton(
                    onClick = {
                        Toast.makeText(context, "FAB clicked!", Toast.LENGTH_SHORT).show()
                    },
                    backgroundColor = Color.DarkGray,
                    content = {
                        Icon(
                            painter = painterResource(id = R.drawable.add_image),
                            contentDescription = null,
                            tint = Color.White
                        )
                    },
                    modifier = Modifier.padding(5.dp)
                )
                ExtendedFloatingActionButton(
                    onClick = {
                        Toast.makeText(context, "FAB clicked!", Toast.LENGTH_SHORT).show()
                    },
                    backgroundColor = Color.DarkGray,
                    text = { Text(text = "Ekle", color = Color.White) },
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.add_image),
                            contentDescription = null,
                            tint = Color.White
                        )
                    },
                    modifier = Modifier.padding(5.dp)
                )
            }
        },
        content = {}
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun FloatingActionButtonPreview() {
    FloatingActionButtonPage()
}