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
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.gray
import com.example.androiddevchallenge.ui.theme.green300
import com.example.androiddevchallenge.ui.theme.white


@Composable
fun loginScreen(navController: NavHostController) {
    Surface(color = MaterialTheme.colors.primary) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){

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
                        .fillMaxWidth(0.95f)
                        .height(56.dp),
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
                        .fillMaxWidth(0.95f)
                        .height(56.dp),
                    onClick = { /*TODO*/ }
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
fun LoginDarkPreview() {
    MyTheme(darkTheme = true) {
        loginScreen(NavHostController(LocalContext.current))
    }
}


@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LoginLightPreview() {
    MyTheme {
        loginScreen(NavHostController(LocalContext.current))
    }
}
