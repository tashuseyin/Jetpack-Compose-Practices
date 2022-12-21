package com.example.jetpackcomposematerialdesign.drawer.page

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun DrawerPageOne() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally 
    ) {
        Text(text = "Page One", fontSize = 50.sp)
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun DrawerPageOnePreview() {
    DrawerPageOne()
}