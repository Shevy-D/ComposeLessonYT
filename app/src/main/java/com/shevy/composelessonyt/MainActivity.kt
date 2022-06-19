package com.shevy.composelessonyt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Green)
            ) {
                itemsIndexed(
                    listOf(
                        ItemRowModel(
                            R.drawable.image_1,
                            "Миша",
                            "test dssdajk dsdadsv df" +
                                    " sFDSf dF DSfF  f dfsffd" +
                                    " sfg safkdjsbk dsabks bkdjbjsacbads" +
                                    "bkdsc bdsbk bjdsbd sbjb jdbjkd kbskbjd sbd" +
                                    "scb jsdba bbjsabjk dakbkdj"
                        ),
                        ItemRowModel(R.drawable.image_2, "Егор", "test"),
                        ItemRowModel(R.drawable.image_3, "Максим", "test"),
                        ItemRowModel(R.drawable.image_4, "Лена", "test"),
                        ItemRowModel(R.drawable.image_5, "Лена", "test"),
                        ItemRowModel(R.drawable.image_1, "Игорь", "test"),
                        ItemRowModel(R.drawable.image_2, "Сергей", "test")
                    )
                ) { index, item ->
                    ItemRow(item = item)
                }
            }
        }
    }
}