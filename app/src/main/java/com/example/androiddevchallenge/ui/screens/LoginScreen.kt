package com.example.androiddevchallenge.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.androiddevchallenge.ui.store.AppStore
import com.example.androiddevchallenge.ui.theme.*


@Composable
fun LoginScreen(navController: NavHostController) {
    Surface(color = MaterialTheme.colors.primary) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                val context = LocalContext.current

                Text(
                    text = "Log in with email",
                    style = MaterialTheme.typography.h1
                )

                Spacer(modifier = Modifier.height(dp8))

                val emailTextState = remember { mutableStateOf(TextFieldValue()) }
                OutlinedTextField(
                    value = emailTextState.value,
                    onValueChange = {
                        emailTextState.value = it
                        AppStore.update {
                            copy(
                                email = it.text
                            )
                        }
                    },
                    modifier = Modifier.fillMaxWidth(0.9f),
                    label = { Text("Email Address") }
                )

                Spacer(modifier = Modifier.height(dp8))

                val passwordTextState = remember { mutableStateOf(TextFieldValue()) }
                OutlinedTextField(
                    value = passwordTextState.value,
                    onValueChange = {
                        passwordTextState.value = it
                        AppStore.update {
                            copy(
                                password = it.text
                            )
                        }
                    },
                    modifier = Modifier.fillMaxWidth(0.9f),
                    label = { Text("Password (8+ characters)") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                )

                Spacer(modifier = Modifier.height(dp8))
                Text(
                    modifier = Modifier.padding(start = dp16, end = dp16),
                    text = buildAnnotatedString {
                        append("By clicking below, you agree to out ")
                        withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
                            append("Terms of Use")
                        }
                        append(" and consent to our ")
                        withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
                            append("Privacy Policy")
                        }
                        append(".")
                    },
                    style = MaterialTheme.typography.body2,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(dp16))

                Button(
                    modifier = Modifier
                        .fillMaxWidth(0.85f)
                        .height(dp48),
                    onClick = {

                        Toast.makeText(
                            context,
                            AppStore.state.value.toString(),
                            Toast.LENGTH_SHORT
                        ).show()
                    },
                    shape = MaterialTheme.shapes.medium,
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = green300,
                        contentColor = gray
                    )
                ) {
                    Text(
                        text = "Log in",
                        style = MaterialTheme.typography.button
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
        LoginScreen(NavHostController(LocalContext.current))
    }
}


@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LoginLightPreview() {
    MyTheme {
        LoginScreen(NavHostController(LocalContext.current))
    }
}
