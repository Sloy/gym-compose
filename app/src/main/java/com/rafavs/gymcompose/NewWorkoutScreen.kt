package com.rafavs.gymcompose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rafavs.gymcompose.ui.theme.GymComposeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewWorkoutScreen() {
    GymComposeTheme {
        Scaffold(
            topBar = {
                SmallTopAppBar(title = { Text("Registrar entrenamiento") },
                    navigationIcon = {
                        IconButton(onClick = { /* doSomething() */ }) {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = "Back"
                            )
                        }
                    },
                    actions = {
                        IconButton(onClick = { /* doSomething() */ }) {
                            Icon(
                                imageVector = Icons.Filled.Search,
                                contentDescription = "Localized description"
                            )
                        }
                    })
            }) { innerPadding ->
            Column(
                Modifier
                    .padding(innerPadding)
                    .padding(16.dp)
            ) {
                var muscleGroupsText by rememberSaveable { mutableStateOf("") }
                OutlinedTextField(
                    value = muscleGroupsText,
                    onValueChange = { muscleGroupsText = it },
                    label = { Text("Muscle Groups") }
                )

                for (i in 1..5) {
                    var exercise by rememberSaveable { mutableStateOf("") }
                    OutlinedTextField(
                        modifier = Modifier.padding(start = 16.dp),
                        value = exercise,
                        onValueChange = { exercise = it },
                        label = { Text("Exercise #$i") }
                    )
                }

            }
        }

    }

}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun NewWorkoutScreenPreview() {
    NewWorkoutScreen()
}