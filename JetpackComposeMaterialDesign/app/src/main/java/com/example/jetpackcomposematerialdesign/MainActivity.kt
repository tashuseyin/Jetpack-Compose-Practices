package com.example.jetpackcomposematerialdesign

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.jetpackcomposematerialdesign.ui.theme.JetpackComposeMaterialDesignTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeMaterialDesignTheme {
                AlertDialogPage()
            }
        }
    }
}

