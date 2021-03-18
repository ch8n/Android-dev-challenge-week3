package com.example.androiddevchallenge.ui.components


import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.*
import com.github.javafaker.Faker
import dev.chrisbanes.accompanist.coil.CoilImage


val imagesAssetIds = listOf(R.raw.asset1, R.raw.asset3, R.raw.asset2)

data class ThemeCardInfo(val assetId: Int, val title: String) {
    companion object {
        fun fake() = ThemeCardInfo(
            assetId = imagesAssetIds.random(),
            title = Faker.instance().name().fullName()
        )
    }
}

@Composable
fun ItemThemeCard(
    modifier: Modifier,
    themeCardInfo: ThemeCardInfo
) {

    Surface(color = if (isSystemInDarkTheme()) gray else white) {

        Card(
            modifier = modifier,
            shape = defaultCardCorner,
            elevation = elevationCard,
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                CoilImage(
                    data = remember { themeCardInfo.assetId },
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.7f),
                    contentScale = ContentScale.Crop,
                )

                Text(
                    modifier = Modifier.padding(horizontal = dp16, vertical = dp8),
                    text = remember { themeCardInfo.title },
                    style = MaterialTheme.typography.h2,
                )
            }
        }

    }

}

@Preview("Dark Theme", widthDp = 136, heightDp = 136)
@Composable
fun HomeDarkPreview() {
    MyTheme(darkTheme = true) {
        ItemThemeCard(
            modifier = Modifier
                .width(136.dp)
                .height(136.dp),
            themeCardInfo = ThemeCardInfo.fake()
        )
    }
}


@Preview("Light Theme", widthDp = 136, heightDp = 136)
@Composable
fun HomeLightPreview() {
    MyTheme {
        ItemThemeCard(
            modifier = Modifier
                .width(136.dp)
                .height(136.dp),
            themeCardInfo = ThemeCardInfo.fake()
        )
    }
}
