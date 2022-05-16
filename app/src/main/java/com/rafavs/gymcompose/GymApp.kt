package com.rafavs.gymcompose

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rafavs.gymcompose.ui.theme.GymComposeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GymApp() {
    GymComposeTheme {
        Scaffold(
            topBar = { CenterAlignedTopAppBar(title = { Text("Gym App") }) },
            floatingActionButton = {
                ExtendedFloatingActionButton(
                    content = { Text("Registrar") },
                    onClick = { /*TODO*/ })
            }
        ) { padding ->

        }

    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    GymApp()
}