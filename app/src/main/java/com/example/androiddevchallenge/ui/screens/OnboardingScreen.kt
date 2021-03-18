package com.example.androiddevchallenge.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.navigation.Screen
import com.example.androiddevchallenge.ui.theme.*


@Composable
fun OnboardingScreen(navController: NavHostController) {
    Surface(color = MaterialTheme.colors.primary) {

        Image(
            painter = painterResource(id = R.drawable.ic_dark_welcome_bg),
            contentDescription = "",
            modifier = Modifier.fillMaxSize()
        )

        Image(
            painter = painterResource(id = R.drawable.ic_dark_welcome_illos),
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth(6f)
                .fillMaxHeight(0.4f)
                .offset(x = dp88, y = dp72)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.85f),
            contentAlignment = Alignment.BottomCenter
        ) {


            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {


                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_dark_logo),
                        contentDescription = "",
                    )

                    Text(
                        modifier = Modifier.padding(top = 4.dp),
                        text = "Beautiful home garden solution",
                        style = MaterialTheme.typography.subtitle1
                    )
                }

                Spacer(modifier = Modifier.height(48.dp))

                Button(
                    modifier = Modifier
                        .fillMaxWidth(0.85f)
                        .height(dp48),
                    onClick = { /*TODO*/ },
                    shape = MaterialTheme.shapes.medium,
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = green300,
                        contentColor = gray
                    )
                ) {
                    Text(
                        text = "Create account",
                        style = MaterialTheme.typography.button
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                TextButton(
                    modifier = Modifier
                        .fillMaxWidth(0.85f)
                        .height(dp48),
                    onClick = {
                        navController.navigate(Screen.Login.route)
                    }
                ) {
                    Text(
                        text = "Log in",
                        style = MaterialTheme.typography.button,
                        color = white
                    )
                }
            }

        }
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        OnboardingScreen(NavHostController(LocalContext.current))
    }
}


@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        OnboardingScreen(NavHostController(LocalContext.current))
    }
}
