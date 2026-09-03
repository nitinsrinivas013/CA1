package com.redspade.ca1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.redspade.ca1.ui.theme.CA1Theme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CA1Theme {
                ProfileScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen() {

    var showSheet by remember { mutableStateOf(false) }
    var role by remember { mutableStateOf("Guest") }
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {

        OutlinedCard(
            modifier = Modifier.padding(20.dp)
        ) {

            Column(
                modifier = Modifier.padding(20.dp)
            ) {

                Text("User Profile")

                Text("Role: $role")

                Spacer(modifier = Modifier.height(10.dp))

                Button(
                    onClick = {
                        showSheet = true
                    }
                ) {
                    Text("View Bio & Settings")
                }
            }
        }

        if (showSheet) {
            ModalBottomSheet(
                onDismissRequest = {
                    showSheet = false
                },
                sheetState = sheetState
            ) {
                Column(
                    modifier = Modifier.padding(20.dp)
                ) {

                    Text("Select Role")

                    Row {
                        RadioButton(
                            selected = role == "Admin",
                            onClick = {
                                role = "Admin"
                            }
                        )

                        Text("Admin")
                    }

                    Row {
                        RadioButton(
                            selected = role == "Member",
                            onClick = {
                                role = "Member"
                            }
                        )

                        Text("Member")
                    }

                    Row {
                        RadioButton(
                            selected = role == "Guest",
                            onClick = {
                                role = "Guest"
                            }
                        )

                        Text("Guest")
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Button(
                        onClick = {

                            scope.launch {
                                sheetState.hide()
                                showSheet = false
                            }
                        }
                    ) {
                        Text("Save & Close")
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                }
            }
        }
    }
}