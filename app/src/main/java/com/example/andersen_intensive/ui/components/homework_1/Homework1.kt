package com.example.andersen_intensive.ui.components.homework_1

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.unit.dp
import com.example.andersen_intensive.R
import com.example.andersen_intensive.ui.components.ArrowDropDownUp

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
    val isClickedLoadImageWithoutLibrary = remember {
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
            DropDownSection(
                isClickedSection = isClickedLoadImageWithoutLibrary,
                name = stringResource(id = R.string.load_image_without_library),
                function = { LoadImageWithoutLibrary() }
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