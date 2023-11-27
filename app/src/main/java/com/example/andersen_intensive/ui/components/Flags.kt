package com.example.andersen_intensive.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp

@Composable
fun Flags() {
    val countryList = listOf(
        Country(name = "Austria", content = { Austria() }),
        Country(name = "Poland", content = { Poland() }),
        Country(name = "Italy", content = { Italy() }),
        Country(name = "Columbia", content = { Columbia() }),
        Country(name = "Madagascar", content = { Madagascar() }),
        Country(name = "Thailand", content = { Thailand() }),
        Country(name = "Denmark", content = { Denmark() }),
        Country(name = "Switzerland", content = { Switzerland() })

    )
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(countryList.size) { item ->
            Column {
                FlagCard(
                    countryName = countryList[item].name,
                    content = countryList[item].content
                )
            }
        }
    }
}

data class Country(
    val name: String,
    val content: @Composable () -> Unit
)

@Composable
fun FlagCard(
    countryName: String,
    content: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier
            .height(150.dp)
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        )
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = countryName)
            content()
        }
    }
}


@Composable
fun Rectangle(
    color: Color,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.composed {
            size(32.dp)
                .clip(RectangleShape)
                .background(color)
        }
    )
}

@Composable
fun Poland() {
    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Rectangle(
            modifier = Modifier
                .fillMaxHeight(0.5f)
                .fillMaxWidth(),
            color = Color.White
        )
        Rectangle(
            modifier = Modifier
                .fillMaxSize(),
            color = Color.Red
        )
    }
}

@Composable
fun Italy() {
    Row(
        modifier = Modifier.padding(16.dp),
    ) {
        Rectangle(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(0.33f),
            color = Color.Green
        )
        Rectangle(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(0.5f),
            color = Color.White
        )
        Rectangle(
            modifier = Modifier
                .fillMaxSize(),
            color = Color.Red
        )
    }
}

@Composable
fun Columbia() {
    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Rectangle(
            modifier = Modifier
                .fillMaxHeight(0.5f)
                .fillMaxWidth(),
            color = Color.Yellow
        )
        Rectangle(
            modifier = Modifier
                .fillMaxHeight(0.5f)
                .fillMaxWidth(),
            color = Color.Blue
        )
        Rectangle(
            modifier = Modifier
                .fillMaxSize(),
            color = Color.Red
        )
    }
}

@Composable
fun Thailand() {
    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Rectangle(
            modifier = Modifier
                .fillMaxHeight(0.2f)
                .fillMaxWidth(),
            color = Color.Red
        )
        Rectangle(
            modifier = Modifier
                .fillMaxHeight(0.2f)
                .fillMaxWidth(),
            color = Color.White
        )
        Rectangle(
            modifier = Modifier
                .fillMaxHeight(0.5f)
                .fillMaxWidth(),
            color = Color.Blue
        )
        Rectangle(
            modifier = Modifier
                .fillMaxHeight(0.5f)
                .fillMaxWidth(),
            color = Color.White
        )
        Rectangle(
            modifier = Modifier
                .fillMaxSize(),
            color = Color.Red
        )

    }
}

@Composable
fun Austria() {
    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Rectangle(
            modifier = Modifier
                .fillMaxHeight(0.33f)
                .fillMaxWidth(),
            color = Color.Red
        )
        Rectangle(
            modifier = Modifier
                .fillMaxHeight(0.5f)
                .fillMaxWidth(),
            color = Color.White
        )
        Rectangle(
            modifier = Modifier
                .fillMaxSize(),
            color = Color.Red
        )
    }
}

@Composable
fun Madagascar() {
    Row(
        modifier = Modifier.padding(16.dp)
    ) {
        Rectangle(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(0.33f),
            color = Color.White
        )
        Column() {
            Rectangle(
                modifier = Modifier
                    .fillMaxHeight(0.5f)
                    .fillMaxWidth(),
                color = Color.Red
            )
            Rectangle(
                modifier = Modifier
                    .fillMaxSize(),
                color = Color.Green
            )
        }

    }
}

@Composable
fun Denmark() {
    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxHeight(0.5f)
                .fillMaxWidth()

        ) {
            Rectangle(
                color = Color.Red, modifier = Modifier.fillMaxHeight()
            )
            Rectangle(
                color = Color.White, modifier = Modifier
                    .fillMaxWidth(0.1f)
                    .fillMaxHeight()
            )
            Rectangle(
                color = Color.Red, modifier = Modifier
                    .fillMaxSize()
            )
        }
        Row(
            modifier = Modifier
                .fillMaxHeight(0.3f)

        ) {
            Rectangle(
                color = Color.White, modifier = Modifier
                    .fillMaxSize()
            )
        }
        Row(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()

        ) {
            Rectangle(
                color = Color.Red
            )
            Rectangle(
                color = Color.White, modifier = Modifier
                    .fillMaxWidth(0.1f)
            )
            Rectangle(
                color = Color.Red, modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}

@Composable
fun Switzerland() {
    Box(
        modifier =
        Modifier
            .fillMaxSize()
            .padding(20.dp)
            .background(Color.Red),
        contentAlignment = Alignment.Center
    ) {
        Row() {
            Rectangle(
                color = Color.White, modifier = Modifier
                    .fillMaxWidth(0.1f)
            )
        }
        Column() {
            Rectangle(
                color = Color.White, modifier = Modifier
                    .fillMaxHeight(0.2f)
            )
        }
    }
}