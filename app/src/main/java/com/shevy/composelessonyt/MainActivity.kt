package com.shevy.composelessonyt

import android.os.Bundle
import android.util.Log
import android.view.RoundedCorner
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.detectDragGesturesAfterLongPress
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shevy.composelessonyt.ui.theme.ComposeLessonYTTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                listItem(name = "Tusha Kutusha", prof = "Actor")
                listItem(name = "Tusha Kutusha", prof = "Actor")
                listItem(name = "Tusha Kutusha", prof = "Actor")
                listItem(name = "Tusha Kutusha", prof = "Actor")
                listItem(name = "Tusha Kutusha", prof = "Actor")
                listItem(name = "Tusha Kutusha", prof = "Actor")
                listItem(name = "Tusha Kutusha", prof = "Actor")
                listItem(name = "Tusha Kutusha", prof = "Actor")
                listItem(name = "Tusha Kutusha", prof = "Actor")
            }

        }
    }
}

@Composable
private fun listItem(name: String, prof: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .pointerInput(Unit){
/*                detectDragGesturesAfterLongPress { change, dragAmount ->
                    Log.d("MyLog", "Long press: $dragAmount")
                }*/
                detectTapGestures {
                    Log.d("MyLog", "Long press: $it")
                }
            }
/*            .clickable {
                Log.d("MyLog", "Clicked")
            }*/,
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp
    ) {
        Box(
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(5.dp)
                        .size(64.dp)
                        .clip(CircleShape)
                )
                Column(modifier = Modifier.padding(start = 16.dp)) {
                    Text(text = name)
                    Text(text = prof)
                }


            }

        }

    }
}