package com.example.jetpackcomposematerialdesign

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
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
fun DynamicLazyRowPage() {
    val context = LocalContext.current
    val countryList = remember { mutableStateListOf("Turkey", "Italy", "Germany", "China") }

    LazyRow {
        items(
            count = countryList.count(),
            itemContent = {
                val country = countryList[it]
                DynamicLazyRowItemDesign(
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
fun DynamicLazyRowItemDesign(
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
            modifier = Modifier
                .padding(all = 10.dp)
                .size(width = 160.dp, height = 50.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = textImage, color = Color.Black, fontSize = 14.sp, modifier = Modifier.weight(4f))

            OutlinedButton(onClick = { onButtonClicked() }, modifier = Modifier.weight(6f)) {
                Text(text = stringResource(R.string.select_country))
            }
        }
    }
}


@Composable
@Preview(showBackground = true, showSystemUi = true)
fun DynamicLazyRowPagePreview() {
    DynamicLazyRowPage()
}