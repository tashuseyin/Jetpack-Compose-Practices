package com.example.jetpackcomposematerialdesign

import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LazyRowPage() {
    val context = LocalContext.current
    LazyRow {
        item {
            LazyRowItemDesign(
                drawableImage = R.drawable.ic_sunny,
                textImage = R.string.sunny,
                onItemClicked = {
                    Toast.makeText(context, "Item 1", Toast.LENGTH_SHORT).show()
                })
        }
        item {
            LazyRowItemDesign(
                drawableImage = R.drawable.ic_sunny,
                textImage = R.string.sunny,
                onItemClicked = {
                    Toast.makeText(context, "Item 2", Toast.LENGTH_SHORT).show()
                })
        }
    }
}


@Composable
fun LazyRowItemDesign(
    @DrawableRes drawableImage: Int,
    @StringRes textImage: Int,
    onItemClicked: () -> Unit
) {
    Card(modifier = Modifier
        .padding(all = 5.dp)
        .size(width = 150.dp, height = 80.dp)
        .clickable { onItemClicked() })
    {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(all = 10.dp)
        ) {
            Image(
                painter = painterResource(id = drawableImage),
                contentDescription = null,
                modifier = Modifier
                    .size(width = 40.dp, height = 40.dp)
                    .padding(end = 10.dp),
                colorFilter = ColorFilter.tint(color = Color.Black)
            )
            Text(text = stringResource(id = textImage), color = Color.Black, fontSize = 18.sp)
        }
    }
}


@Composable
@Preview(showBackground = true, showSystemUi = true)
fun LazyRowPagePreview() {
    LazyRowPage()
}