package com.example.androiddevchallenge.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.androiddevchallenge.ui.components.GardenItemColumn
import com.example.androiddevchallenge.ui.components.GardenThemeRow
import com.example.androiddevchallenge.ui.theme.*


@Composable
fun HomeScreen(navController: NavHostController) {
    Surface(color = MaterialTheme.colors.primary) {
        Column(Modifier.fillMaxSize().padding(horizontal = dp16)) {

            val searchTextValue = remember { mutableStateOf(TextFieldValue()) }
            OutlinedTextField(
                value = searchTextValue.value,
                onValueChange = {
                    searchTextValue.value = it
                },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Search") }
            )

            Spacer(modifier = Modifier.height(dp16))

            Text(
                text = "Browse themes",
                style = MaterialTheme.typography.h1
            )

            Spacer(modifier = Modifier.height(dp4))

            GardenThemeRow(
                modifier = Modifier.fillMaxWidth().clipToBounds(),
            )

            Spacer(modifier = Modifier.height(dp16))

            Text(
                text = "Design your home garden",
                style = MaterialTheme.typography.h1
            )

            Spacer(modifier = Modifier.height(dp4))

            GardenItemColumn(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
            )

        }
    }

}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun HomeDarkPreview() {
    MyTheme(darkTheme = true) {
        LoginScreen(NavHostController(LocalContext.current))
    }
}


@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun HomeLightPreview() {
    MyTheme {
        LoginScreen(NavHostController(LocalContext.current))
    }
}
