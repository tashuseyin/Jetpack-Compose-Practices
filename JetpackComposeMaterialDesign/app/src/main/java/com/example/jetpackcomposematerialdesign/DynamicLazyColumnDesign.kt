package com.example.jetpackcomposematerialdesign

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DynamicLazyColumnPage() {
    val context = LocalContext.current
    val countryList = remember { mutableStateListOf("Turkey", "Italy", "Germany", "China") }

    LazyColumn {
        items(
            count = countryList.count(),
            itemContent = {
                val country = countryList[it]
                DynamicLazyColumItemDesign(
                    textImage = country,
                    onItemClicked = {
                        Toast.makeText(context, "Item $it", Toast.LENGTH_SHORT).show()
                    },
                    onButtonClicked = {
                        Toast.makeText(context, "Selected $country", Toast.LENGTH_SHORT).show()
                    }
                )
            }
        )
    }
}

@Composable
fun DynamicLazyColumItemDesign(
    textImage: String,
    onItemClicked: () -> Unit,
    onButtonClicked: () -> Unit
) {
    Card(modifier = Modifier
        .padding(all = 5.dp)
        .fillMaxWidth()
        .clickable { onItemClicked() })
    {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(all = 10.dp).fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = textImage, color = Color.Black, fontSize = 18.sp)

            OutlinedButton(onClick = { onButtonClicked() }) {
                Text(text = stringResource(R.string.select_country))
            }
        }
    }
}


@Composable
@Preview(showBackground = true, showSystemUi = true)
fun DynamicLazyColumnPagePreview() {
    DynamicLazyColumnPage()
}