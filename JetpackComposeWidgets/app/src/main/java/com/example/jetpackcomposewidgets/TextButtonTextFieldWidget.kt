package com.example.jetpackcomposewidgets

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextButtonTextField() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        val textFieldValue = remember { mutableStateOf("") }
        val outlinedTextFieldValue = remember { mutableStateOf("") }
        val textValue = remember { mutableStateOf("") }

        Text(
            text = "Gelen Veri: ${textValue.value}",
            color = Color.White,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            style = TextStyle(background = Color.DarkGray)
        )
        TextField(
            value = textFieldValue.value,
            onValueChange = { textFieldValue.value = it },
            label = {
                Text(
                    text = "Veri Giriniz."
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.DarkGray,
                textColor = Color.White,
                focusedIndicatorColor = Color.Green,
                focusedLabelColor = Color.Yellow,
                cursorColor = Color.Yellow
            ),
            visualTransformation =  PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword)
        )

        Button(
            onClick = {
                textValue.value = textFieldValue.value
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Red,
                contentColor = Color.White
            ),
            border = BorderStroke(2.dp, color = Color.Yellow),
            shape = RoundedCornerShape(50)
        ) {
            Text(text = "Veriyi Al")
        }

        OutlinedTextField(
            value = outlinedTextFieldValue.value,
            onValueChange = { outlinedTextFieldValue.value = it },
            label = {
                Text(
                    text = "Veri Giriniz."
                )
            })

        OutlinedButton(onClick = {
            textValue.value = outlinedTextFieldValue.value
        }) {
            Text(text = "Outlined Veriyi Al")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TextButtonTextFieldPreview() {
    TextButtonTextField()
}