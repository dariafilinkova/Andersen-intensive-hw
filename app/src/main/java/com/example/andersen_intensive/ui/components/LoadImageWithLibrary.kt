package com.example.andersen_intensive.ui.components

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoadImageWithLibrary() {
    val showShimmer = remember { mutableStateOf(true) }
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        val url = remember { mutableStateOf("https://cataas.com/cat") }
        OutlinedTextField(
            value = url.value,
            onValueChange = { url.value = it },
            label = { Text("Load image") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        AsyncImage(
            model = url.value,
            contentDescription = "random cat pic",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(270.dp)
                .clip(RoundedCornerShape(20.dp))
                .border(BorderStroke(2.dp, Color.Cyan), RoundedCornerShape(20.dp))
                .background(
                    shimmerBrush(
                        targetValue = 1300f,
                        showShimmer = showShimmer.value
                    )
                ),
            onSuccess = {
                showShimmer.value = false
            },
            onError = {
                Toast.makeText(context, "Failed.Try Again later!", Toast.LENGTH_SHORT).show()
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LoadImageWithLibrary()
}