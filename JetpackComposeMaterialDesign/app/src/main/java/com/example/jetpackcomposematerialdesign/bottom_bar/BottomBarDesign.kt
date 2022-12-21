package com.example.jetpackcomposematerialdesign.bottom_bar

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcomposematerialdesign.R
import com.example.jetpackcomposematerialdesign.bottom_bar.page.PageOne
import com.example.jetpackcomposematerialdesign.bottom_bar.page.PageTwo

@Composable
fun BottomBarDesignPage() {
    var selectedItem by remember { mutableStateOf(0) }
    Scaffold(
        topBar = {
            TopAppBarDesign()
        },
        content = {
            when (selectedItem) {
                0 -> PageOne()
                else -> PageTwo()
            }
        },
        bottomBar = {
            BottomBarDesign(selectedItem = selectedItem, selectedItemClick = { selectedItem = it })
        }
    )
}

@Composable
fun TopAppBarDesign() {
    TopAppBar(
        title = { Text(text = stringResource(id = R.string.top_app_bar_title)) },
        backgroundColor = colorResource(id = R.color.main_color),
        contentColor = Color.White
    )
}

@Composable
fun BottomBarDesign(
    selectedItem: Int,
    selectedItemClick: (Int) -> Unit
) {
    BottomAppBar(
        backgroundColor = colorResource(id = R.color.main_color),
        content = {
            BottomNavigation(backgroundColor = colorResource(id = R.color.main_color)) {
                BottomNavigationItem(
                    selected = selectedItem == 0,
                    onClick = { selectedItemClick(0) },
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_looks_one_24),
                            contentDescription = null
                        )
                    },
                    label = { Text(text = "Page One") },
                    selectedContentColor = Color.Blue,
                    unselectedContentColor = Color.White
                )

                BottomNavigationItem(
                    selected = selectedItem == 1,
                    onClick = { selectedItemClick(1) },
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_looks_two_24),
                            contentDescription = null
                        )
                    },
                    label = { Text(text = "Page Two") },
                    selectedContentColor = Color.Blue,
                    unselectedContentColor = Color.White
                )
            }
        }
    )
}

@Composable
@Preview(showSystemUi = true, showBackground = true)
fun BottomBarPagePreview() {
    BottomBarDesignPage()
}