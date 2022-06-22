package com.shevy.composelessonyt

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.shevy.composelessonyt.MainActivity as MainActivity1

@Composable
fun GeoQueez(context: Context) {

/*    var isExpanded by remember {
        mutableStateOf(false)
    }*/

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
    ) {
        Column(
            Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Canberra is the capital of Australia",
                color = Color.White
            )
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(16.dp)
            )
            Row() {
                Button(onClick = {
                    Toast.makeText(
                        context,
                        "Correct!",
                        Toast.LENGTH_SHORT,
                    ).show()
                }) {
                    Text(text = "True")
                }
                Spacer(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(16.dp)
                )
                Button(onClick = {
                    Toast.makeText(
                        context,
                        "Incorrect!",
                        Toast.LENGTH_SHORT,
                    ).show()
                }) {
                    Text(text = "False")
                }
            }
        }
    }
}

/*Row(
    modifier = Modifier
        .padding(3.dp)
        .fillMaxWidth()
        .background(Color.White)
) {
    Image(
        painter = painterResource(id = item.imageId),
        contentDescription = "image",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(3.dp)
            .size(64.dp)
            .clip(CircleShape)
    )
    Column(
        modifier = Modifier
            .padding(start = 10.dp, top = 10.dp)
    ) {
        Text(text = item.title)
        Text(modifier = Modifier.clickable {
            isExpanded = !isExpanded
        }, maxLines = if (isExpanded) 10 else 1, text = item.content)
    }
}*/

fun trueAnswer(context: Context) {
    Toast.makeText(
        context,
        "R.string.correct_toast.toString()",
        Toast.LENGTH_SHORT
    ).show()
}
