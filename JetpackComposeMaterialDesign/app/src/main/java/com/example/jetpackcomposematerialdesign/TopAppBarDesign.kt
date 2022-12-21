package com.example.jetpackcomposematerialdesign

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp


@Composable
fun TopAppBarPage() {
    val context = LocalContext.current
    Scaffold(
        topBar = {
            TopAppBarDesign(
                onExitAppClicked = {
                    Toast.makeText(context, "Exit App", Toast.LENGTH_SHORT).show()
                },
                onMenuClicked = {
                    Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
                }
            )
        },
        content = {}
    )
}

@Composable
fun TopAppBarDesign(onExitAppClicked: () -> Unit, onMenuClicked: (String) -> Unit) {
    TopAppBar(
        title = {
            Column {
                Text(text = stringResource(R.string.top_app_bar_title), fontSize = 18.sp)
                Text(text = stringResource(R.string.top_app_bar_subtitle), fontSize = 12.sp)
            }
        },
        backgroundColor = colorResource(id = R.color.main_color),
        contentColor = Color.White,
        actions = {
            ExitAction(onExitAppClicked = onExitAppClicked)
            MenuAction(onMenuClicked = onMenuClicked)
        }
    )
}

@Composable
fun ExitAction(onExitAppClicked: () -> Unit) {
    IconButton(onClick = { onExitAppClicked() }) {
        Icon(imageVector = Icons.Default.ExitToApp, contentDescription = null)
    }
}

@Composable
fun MenuAction(onMenuClicked: (String) -> Unit) {
    var expandedMenu by remember { mutableStateOf(false) }

    IconButton(onClick = { expandedMenu = true }) {
        Icon(imageVector = Icons.Default.Menu, contentDescription = null)
    }

    DropdownMenu(expanded = expandedMenu, onDismissRequest = { expandedMenu = false }) {
        DropdownMenuItem(onClick = {
            onMenuClicked("Delete")
            expandedMenu = false
        }) {
            Text(text = "Delete")
        }

        DropdownMenuItem(onClick = {
            onMenuClicked("Update")
            expandedMenu = false
        }) {
            Text(text = "Update ")
        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun TopAppBarPreview() {
    TopAppBarPage()
}