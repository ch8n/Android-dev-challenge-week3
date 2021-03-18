package com.example.androiddevchallenge.ui.components


import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
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
fun GardenThemeRow(
    modifier: Modifier
) {

    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(dp8),
    ) {
        items(100) { index: Int ->
            ItemThemeCard(
                modifier = Modifier
                    .width(136.dp)
                    .height(136.dp),
                themeCardInfo = ThemeCardInfo.fake()
            )
        }
    }


}

@Preview("Dark Theme", widthDp = 136, heightDp = 136)
@Composable
fun ThemeRowDarkPreview() {
    MyTheme(darkTheme = true) {
        GardenThemeRow(
            modifier = Modifier.fillMaxWidth(),
        )
    }
}


@Preview("Light Theme", widthDp = 136, heightDp = 136)
@Composable
fun ThemeRowLightPreview() {
    MyTheme {
        GardenThemeRow(
            modifier = Modifier.fillMaxWidth(),
        )
    }
}


