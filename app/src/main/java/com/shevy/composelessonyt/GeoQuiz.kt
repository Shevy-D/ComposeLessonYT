package com.shevy.composelessonyt

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.shevy.composelessonyt.model.Question

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
                text = questionTextView.value,
                color = Color.White
            )
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(5.dp)
            )
            Row() {
                Button(modifier = Modifier.padding(10.dp), onClick = {
                    checkAnswer(true, context, currentIndex.value)
                }) {
                    Text("True")
                }
/*                Spacer(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(16.dp)
                )*/
                Button(modifier = Modifier.padding(10.dp), onClick = {
                    checkAnswer(false, context, currentIndex.value)
                }) {
                    Text("False")
                }
            }

            Row() {
                Button(modifier = Modifier.padding(10.dp), onClick = {
                    if (currentIndex.value != 0) {
                        currentIndex.value = (currentIndex.value - 1) % questionBank.size
                        //updateQuestion(currentIndex.value, questionTextView.value)
                    }
                }) {
                    Image(painter = painterResource(id = R.drawable.arrow_left), contentDescription = "Button last")
                }

                Button(modifier = Modifier.padding(10.dp), onClick = {
                    currentIndex.value = (currentIndex.value + 1) % questionBank.size
                    //updateQuestion(currentIndex.value, questionTextView.value)
                }) {
                    Image(painter = painterResource(id = R.drawable.arrow_right), contentDescription = "Button next")
                }
            }
        }
    }

    val questionTextResId = questionBank[currentIndex.value].textResId
    questionTextView.value = stringResource(id = questionTextResId)
}

private fun checkAnswer(userAnswer: Boolean, context: Context, currentIndex: Int) {
    val correctAnswer = questionBank[currentIndex].answer
    val messageResId = if (userAnswer == correctAnswer) {
        R.string.correct_toast
    } else {
        R.string.incorrect_toast
    }
    Toast.makeText(context, messageResId, Toast.LENGTH_SHORT).show()
}