package com.shevy.composelessonyt

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shevy.composelessonyt.ui.theme.ComposeLessonYTTheme

const val EXTRA_ANSWER_SHOWN = "com.shevy.androidprofessional.controller.answer_shown"
private const val EXTRA_ANSWER_IS_TRUE = "com.shevy.androidprofessional.controller.answer_is_true"


class CheatActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            cheating()
        }
    }

    @Composable
    fun cheating(){
        val answerTextView = remember {
            mutableStateOf("")
        }

        val answerIsTrue = remember {
            mutableStateOf(false)
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = stringResource(id = R.string.warning_text), fontSize = 16.sp)

                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .width(16.dp)
                )

                Text(text = answerTextView.value, fontSize = 16.sp)

                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .width(16.dp)
                )

                Button(onClick = {
                    val answerText = when {
                        answerIsTrue.value -> R.string.true_button
                        else -> R.string.false_button
                    }
                    //answerTextView.value = stringResource(id = answerText)
                    setAnswerShownResult(true)
                }) {
                    Text(text = stringResource(id = R.string.show_answer_button))
                }
            }
        }
    }

    private fun setAnswerShownResult(isAnswerShown: Boolean) {
        val data = Intent().apply {
            putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown)
        }
        setResult(Activity.RESULT_OK, data)
    }

    companion object {
        fun newIntent(packageContext: Context, answerIsTrue: Boolean): Intent {
            return Intent(packageContext, CheatActivity::class.java).apply {
                putExtra(EXTRA_ANSWER_IS_TRUE, answerIsTrue)
            }
        }
    }
}