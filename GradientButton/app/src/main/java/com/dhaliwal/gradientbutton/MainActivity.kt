package com.dhaliwal.gradientbutton

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.dhaliwal.gradientbutton.ui.theme.GradientButtonTheme
import com.dhaliwal.gradientbutton.ui.theme.pink
import com.dhaliwal.gradientbutton.ui.theme.yellowish

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GradientButtonTheme (darkTheme = false){
                Surface(
                    modifier = Modifier
                        .background(Color.Black)
                        .fillMaxSize()
                        .statusBarsPadding()
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .statusBarsPadding(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        GradientButton(text = "Sample Text",
                            textColor = Color.Red,
                            gradient = Brush.linearGradient(listOf(
                                pink,
                                yellowish
                            )),
                            onClick = {}
                        )
                    }
                }
            }
        }

    }
    fun showToastMsg(text : String){
        Toast.makeText(this@MainActivity, text, Toast.LENGTH_SHORT).show()
    }
}
