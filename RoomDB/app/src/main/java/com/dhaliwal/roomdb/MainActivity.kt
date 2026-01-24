package com.dhaliwal.roomdb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.dhaliwal.roomdb.db_files.AppDatabase
import com.dhaliwal.roomdb.ui.theme.RoomDBTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // state to hold name from DB
        val nameState = mutableStateOf("Loading...")

        // DB WORK (background thread)
        lifecycleScope.launch {
            val name = withContext(Dispatchers.IO) {
                val db = Room.databaseBuilder(
                    applicationContext,
                    AppDatabase::class.java,
                    "person"
                )
                    .createFromAsset("database/person.db")
                    .build()

                val personList = db.personDao().getAllData()
                personList.firstOrNull()?.name ?: "No Data"
            }

            nameState.value = name
        }

        setContent {
            RoomDBTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .statusBarsPadding()
                        .background(Color.Black)
                ) {
                    Greeting(name = nameState.value)
                }
            }
        }
    }
}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        color = Color.White,
        modifier = modifier.padding(16.dp)
    )
}
