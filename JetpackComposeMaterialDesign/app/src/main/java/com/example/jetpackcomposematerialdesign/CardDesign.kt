package com.example.jetpackcomposematerialdesign

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CardDesignPage() {
    val context = LocalContext.current
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
        CardDesign(onCardClicked = {
            Toast.makeText(context, "Card Clicked!", Toast.LENGTH_SHORT).show()
        })
    }
}

@Composable
fun CardDesign(onCardClicked: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .clickable { onCardClicked() },
        elevation = 10.dp,
        backgroundColor = Color.Blue,
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        border = BorderStroke(width = 2.dp, color = Color.Magenta)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(all = 10.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_sunny),
                contentDescription = null,
                modifier = Modifier.size(50.dp)
            )
            Text(text = "Sunny", color = Color.White, fontSize = 36.sp)

        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun CardDesignPagePreview() {
    CardDesignPage()
}