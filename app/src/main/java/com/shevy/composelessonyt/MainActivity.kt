package com.shevy.composelessonyt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.shevy.composelessonyt.ui.theme.ComposeLessonYTTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Row(
                modifier = Modifier
                    .background(Color.Yellow)
                    .fillMaxSize()
            ) {
                Column(modifier = Modifier
                    .background(Color.Green)
                    .fillMaxHeight()
                    .fillMaxWidth(0.5f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceAround
                ) {
                    Text(text = "Hello!")
                    Text(text = "Dmitriy!")
                    Text(text = "Hello!")
                }
                Column(modifier = Modifier
                    .background(Color.Red)
                    .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceAround
                ) {
                    Text(text = "Hello!")
                    Text(text = "Dmitriy!")
                    Text(text = "Hello!")
                }
            }
        }
    }
}