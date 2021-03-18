package com.example.androiddevchallenge.ui.components


import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.*
import com.github.javafaker.Faker
import dev.chrisbanes.accompanist.coil.CoilImage
import java.util.*


data class GardenRowItemInfo(
    val itemId: String = UUID.randomUUID().toString(),
    val assetId: Int,
    val title: String,
    val descriptor: String,
    var isChecked: Boolean,
) {
    companion object {
        fun fake() = GardenRowItemInfo(
            assetId = imagesAssetIds.random(),
            title = Faker.instance().name().fullName(),
            descriptor = Faker.instance().lorem().paragraph(),
            isChecked = false
        )
    }
}

@Composable
fun ItemRowGarden(
    gardenInfo: GardenRowItemInfo
) {


    Row(
        Modifier
            .fillMaxWidth()
            .height(100.dp)
    ) {
        CoilImage(
            data = remember { gardenInfo.assetId },
            contentDescription = "",
            modifier = Modifier
                .width(100.dp)
                .height(100.dp),
            contentScale = ContentScale.Crop,
        )

        Spacer(modifier = Modifier.width(dp16))

        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center
            ) {

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = remember { gardenInfo.title },
                    style = MaterialTheme.typography.h2,
                )

                Spacer(modifier = Modifier.height(dp4))

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = dp40),
                    text = remember { gardenInfo.descriptor },
                    style = MaterialTheme.typography.body1,
                    maxLines = 2
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(end = dp8),
                contentAlignment = Alignment.BottomCenter
            ) {

                Divider(color = MaterialTheme.colors.onPrimary, thickness = 2.dp)

            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(end = dp8),
                contentAlignment = Alignment.CenterEnd
            ) {

                val checkBoxState = remember { mutableStateOf(gardenInfo.isChecked) }

                Checkbox(
                    checked = checkBoxState.value,
                    onCheckedChange = {
                        checkBoxState.value = it
                    },
                )
            }


        }


    }


}

@Preview("Dark Theme", widthDp = 136, heightDp = 136)
@Composable
fun ItemRowGardenDarkPreview() {
    MyTheme(darkTheme = true) {
        ItemRowGarden(
            gardenInfo = GardenRowItemInfo.fake()
        )
    }
}


@Preview("Light Theme", widthDp = 136, heightDp = 136)
@Composable
fun ItemRowGardenLightPreview() {
    MyTheme {
        ItemRowGarden(
            gardenInfo = GardenRowItemInfo.fake()
        )
    }
}

