/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.core.view.WindowCompat
import com.example.androiddevchallenge.ui.theme.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyTheme(darkTheme = true) {
                MyApp()
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp() {
    Surface(color = MaterialTheme.colors.primary) {

        Image(
            painter = painterResource(id = R.drawable.ic_dark_welcome_bg),
            contentDescription = "",
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()

        )

        Image(
            painter = painterResource(id = R.drawable.ic_dark_welcome_illos),
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
                .offset(x = 50.dp, y = 50.dp)
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
                        .fillMaxWidth(0.95f)
                        .height(56.dp),
                    onClick = { /*TODO*/ },
                    shape = MaterialTheme.shapes.medium,
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

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}
