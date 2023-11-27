package com.example.andersen_intensive

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.andersen_intensive.ui.components.ArrowDropDownUp
import com.example.andersen_intensive.ui.components.Flags
import com.example.andersen_intensive.ui.theme.AndersenintensiveTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndersenintensiveTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Homework1()
                }
            }
        }
    }
}

@Composable
fun Homework1() {
    val isClickedFlags = remember {
        mutableStateOf(false)
    }
    Column() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .border(
                    1.dp, Color.Black,
                    RectangleShape
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Flags", modifier = Modifier.padding(16.dp))
            Spacer(modifier = Modifier.weight(1f))
            ArrowDropDownUp(isClicked = isClickedFlags)
        }
        if (isClickedFlags.value) {
            Flags()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Flags()
}