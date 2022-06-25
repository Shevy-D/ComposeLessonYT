package com.shevy.composelessonyt

import android.content.Context
import android.widget.ImageButton
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
import com.shevy.composelessonyt.model.Question
import com.shevy.composelessonyt.MainActivity as MainActivity1

private val questionBank = listOf(
    Question(R.string.question_australia, true),
    Question(R.string.question_oceans, true),
    Question(R.string.question_mideast, false),
    Question(R.string.question_africa, false),
    Question(R.string.question_america, true),
    Question(R.string.question_asia, true)
)

@Composable
fun GeoQueez(context: Context) {

    val currentIndex = remember {
        mutableStateOf(0)
    }
    val questionTextView = remember {
        mutableStateOf("Canberra is the capital of Australia.")
    }

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
                text = questionTextView,
                color = Color.White
            )
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(5.dp)
            )
            Row() {
                Button(modifier = Modifier.padding(10.dp), onClick = {
                    checkAnswer(true, context)
                }) {
                    Text(text = "True")
                }
/*                Spacer(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(16.dp)
                )*/
                Button(modifier = Modifier.padding(10.dp), onClick = {
                    checkAnswer(false, context)
                }) {
                    Text(text = "False")
                }
            }

            Row() {
                Button(modifier = Modifier.padding(10.dp), onClick = {
                    if (currentIndex != 0) {
                        currentIndex = (currentIndex - 1) % questionBank.size
                        updateQuestion()
                    }
                }) {
                    Image(painter = painterResource(id = R.drawable.arrow_left), contentDescription = "Button last")
                }

                Button(modifier = Modifier.padding(10.dp), onClick = {
                    currentIndex = (currentIndex + 1) % questionBank.size
                    updateQuestion()
                }) {
                    Image(painter = painterResource(id = R.drawable.arrow_right), contentDescription = "Button next")
                }
            }
        }
    }

    val questionTextResId = questionBank[currentIndex].textResId.toString()
    questionTextView = questionTextResId
}

private fun updateQuestion() {
    val questionTextResId = questionBank[currentIndex].textResId
    questionTextView = questionTextResId.toString()
}

private fun checkAnswer(userAnswer: Boolean, context: Context) {
    val correctAnswer = questionBank[currentIndex].answer
    val messageResId = if (userAnswer == correctAnswer) {
        R.string.correct_toast
    } else {
        R.string.incorrect_toast
    }
    Toast.makeText(context, messageResId, Toast.LENGTH_SHORT).show()
}
