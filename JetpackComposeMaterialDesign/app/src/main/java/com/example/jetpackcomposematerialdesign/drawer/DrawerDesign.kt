package com.example.jetpackcomposematerialdesign.drawer

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposematerialdesign.R
import com.example.jetpackcomposematerialdesign.drawer.page.DrawerPageOne
import com.example.jetpackcomposematerialdesign.drawer.page.DrawerPageTwo
import kotlinx.coroutines.launch

@Composable
fun DrawerDesignPage() {
    var selectedItem by remember { mutableStateOf(0) }
    val scaffoldState =
        rememberScaffoldState(rememberDrawerState(initialValue = DrawerValue.Closed))
    val scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBarDesign(
                onDrawerMenuClicked = {
                    scope.launch {
                        scaffoldState.drawerState.open()
                    }
                }
            )
        },
        content = {
            when (selectedItem) {
                0 -> DrawerPageOne()
                else -> DrawerPageTwo()
            }
        },
        drawerContent = {
            DrawerHeaderDesign()

            DrawerItemDesign(
                drawableIcon = R.drawable.ic_baseline_looks_one_24,
                stringText = R.string.page_one,
                onSelectedItemClick = {
                    scope.launch {
                        scaffoldState.drawerState.close()
                    }
                    selectedItem = 0
                }
            )
            DrawerItemDesign(
                drawableIcon = R.drawable.ic_baseline_looks_two_24,
                stringText = R.string.page_two,
                onSelectedItemClick = {
                    scope.launch {
                        scaffoldState.drawerState.close()
                    }
                    selectedItem = 1
                }
            )
        }
    )

    val activity = (LocalContext.current as Activity)
    BackHandler(onBack = {
        if (scaffoldState.drawerState.isOpen){
             scope.launch {
                 scaffoldState.drawerState.close()
             }
        } else {
            activity.finish()
        }
    })
}

@Composable
fun TopAppBarDesign(
    onDrawerMenuClicked: () -> Unit
) {
    TopAppBar(
        title = { Text(text = stringResource(id = R.string.top_app_bar_title)) },
        backgroundColor = colorResource(id = R.color.main_color),
        contentColor = Color.White,
        navigationIcon = {
            Icon(
                imageVector = Icons.Filled.Menu,
                contentDescription = null,
                modifier = Modifier.clickable { onDrawerMenuClicked() })
        }
    )
}

@Composable
fun DrawerHeaderDesign() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .size(120.dp)
            .background(color = Color.Blue),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Drawer Header", fontSize = 36.sp, color = Color.White)
    }
}


@Composable
fun DrawerItemDesign(
    @DrawableRes drawableIcon: Int,
    @StringRes stringText: Int,
    onSelectedItemClick: () -> Unit
) {
    DropdownMenuItem(onClick = {
        onSelectedItemClick()
    }) {
        Row {
            Image(
                painter = painterResource(id = drawableIcon),
                contentDescription = null
            )
            Text(text = stringResource(id = stringText))
        }
    }
}

@Composable
@Preview(showSystemUi = true, showBackground = true)
fun DrawerPagePreview() {
    DrawerDesignPage()
}