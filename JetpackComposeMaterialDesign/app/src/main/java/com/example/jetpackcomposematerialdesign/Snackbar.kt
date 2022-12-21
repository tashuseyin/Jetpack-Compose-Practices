package com.example.jetpackcomposematerialdesign

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch

@Composable
fun SnackBarDesignPage() {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        snackbarHost = {
            SnackbarHost(hostState = it) { snackBarData ->
                Snackbar(
                    backgroundColor =  Color.White,
                    contentColor = Color.Blue,
                    actionColor = Color.Red,
                    snackbarData = snackBarData
                )
            }
        },
        content = {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(onClick = {
                    scope.launch {
                        scaffoldState.snackbarHostState.showSnackbar("No Internet Connection!")
                    }
                }) {
                    Text(text = "Default SnackBar")
                }
                Button(onClick = {
                    scope.launch {
                        val actionSnackBar = scaffoldState.snackbarHostState.showSnackbar(
                            "No Internet Connection!",
                            actionLabel = "Retry"
                        )
                        if (actionSnackBar == SnackbarResult.ActionPerformed) {
                            scaffoldState.snackbarHostState.showSnackbar("Make sure you have i nternet connection!")
                        }
                    }
                }) {
                    Text(text = "Action SnackBar")
                }
                Button(onClick = {
                    scope.launch {
                        val actionSnackBar = scaffoldState.snackbarHostState.showSnackbar(
                            "No Internet Connection!",
                            actionLabel = "Retry"
                        )
                        if (actionSnackBar == SnackbarResult.ActionPerformed) {
                            scaffoldState.snackbarHostState.showSnackbar("Make sure you have i nternet connection!")
                        }
                    }
                }) {
                    Text(text = "Custom SnackBar")
                }
            }
        }
    )
}

@Composable
@Preview(showSystemUi = true, showBackground = true)
fun SnackBarDesignPagePreview() {
    SnackBarDesignPage()
}