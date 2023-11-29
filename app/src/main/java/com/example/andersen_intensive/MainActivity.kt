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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.andersen_intensive.ui.components.ArrowDropDownUp
import com.example.andersen_intensive.ui.components.Clock
import com.example.andersen_intensive.ui.components.Flags
import com.example.andersen_intensive.ui.components.LoadImageWithLibrary
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
    val isClickedLoadImageWithLibrary = remember {
        mutableStateOf(false)
    }
    val isClickedClock = remember {
        mutableStateOf(false)
    }

    Column(modifier = Modifier.padding(4.dp)) {
        DropDownSection(
            isClickedSection = isClickedFlags,
            name = stringResource(id = R.string.flags),
            function = { Flags() }
        )
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            DropDownSection(
                isClickedSection = isClickedLoadImageWithLibrary,
                name = stringResource(id = R.string.load_image_with_library),
                function = { LoadImageWithLibrary() }
            )
            DropDownSection(
                isClickedSection = isClickedClock,
                name = stringResource(id = R.string.clock),
                function = { Clock() }
            )
        }
    }
}

@Composable
fun DropDownSection(
    isClickedSection: MutableState<Boolean>,
    name: String,
    function: @Composable () -> Unit = {}
) {
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
        Text(name, modifier = Modifier.padding(16.dp))
        Spacer(modifier = Modifier.weight(1f))
        ArrowDropDownUp(isClicked = isClickedSection)
    }
    if (isClickedSection.value) {
        function()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Flags()
}