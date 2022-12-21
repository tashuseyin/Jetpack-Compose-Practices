package com.example.jetpackcomposematerialdesign

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun SearchAppBarPage() {
    var searchValue by remember { mutableStateOf(false) }
    var searchText by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            if (searchValue) {
                SearchAppBar(
                    text = searchText,
                    onTextChange = { searchText = it },
                    onSearchClicked = {},
                    onCloseClicked = {
                        searchValue = false
                        searchText = ""
                    }
                )
            } else {
                DefaultAppBarDesign(onSearchClicked = { searchValue = true })
            }
        },
        content = {}
    )
}

@Composable
fun DefaultAppBarDesign(
    onSearchClicked: () -> Unit
) {
    TopAppBar(
        title = {
            Text(text = stringResource(R.string.search_app_bar), color = Color.White)
        },
        backgroundColor = colorResource(id = R.color.main_color),
        contentColor = Color.White,
        actions = {
            SearchAction(onSearchClicked = onSearchClicked)
        }
    )
}


@Composable
fun SearchAppBar(
    text: String,
    onTextChange: (String) -> Unit,
    onCloseClicked: () -> Unit,
    onSearchClicked: (String) -> Unit
) {

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        elevation = AppBarDefaults.TopAppBarElevation
    ) {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = text,
            onValueChange = { onTextChange(it) },
            placeholder = {
                Text(
                    modifier = Modifier.alpha(ContentAlpha.medium),
                    text = stringResource(R.string.search),
                    color = Color.White
                )
            },
            textStyle = TextStyle(
                fontSize = MaterialTheme.typography.subtitle1.fontSize
            ),
            singleLine = true,
            leadingIcon = {
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = stringResource(R.string.search_icon),
                        tint = Color.White
                    )
                }
            },
            trailingIcon = {
                IconButton(onClick = { onCloseClicked() }) {
                    Icon(
                        imageVector = Icons.Filled.Close,
                        contentDescription = stringResource(R.string.close_icon),
                        tint = Color.White
                    )
                }
            },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(onSearch = {
                onSearchClicked(text)
            }),
            colors = TextFieldDefaults.textFieldColors(
                cursorColor = colorResource(id = R.color.main_color),
                focusedIndicatorColor = Color.White,
                disabledIndicatorColor = Color.White,
                unfocusedIndicatorColor = Color.White,
                backgroundColor = colorResource(id = R.color.main_color),
                textColor = Color.White
            )
        )
    }
}


@Composable
fun SearchAction(
    onSearchClicked: () -> Unit
) {
    IconButton(onClick = { onSearchClicked() }) {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = stringResource(R.string.search),
        )
    }
}


@Composable
@Preview(showBackground = true, showSystemUi = true)
fun SearchAppBarPreview() {
    SearchAppBarPage()
}