package com.example.androiddevchallenge.ui.components


import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.dp8
import com.example.androiddevchallenge.ui.theme.gray
import com.example.androiddevchallenge.ui.theme.white


@Composable
fun GardenItemColumn(
    modifier: Modifier
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(dp8),
    ) {
        items(100) { index: Int ->
            ItemRowGarden(
                GardenRowItemInfo.fake()
            )
        }
    }
}

@Preview("Dark Theme", widthDp = 136, heightDp = 136)
@Composable
fun GardenItemColumnDarkPreview() {
    MyTheme(darkTheme = true) {
        GardenItemColumn(
            modifier = Modifier.fillMaxSize(),
        )
    }
}


@Preview("Light Theme", widthDp = 136, heightDp = 136)
@Composable
fun GardenItemColumnLightPreview() {
    MyTheme {
        GardenItemColumn(
            modifier = Modifier.fillMaxSize(),
        )
    }
}


