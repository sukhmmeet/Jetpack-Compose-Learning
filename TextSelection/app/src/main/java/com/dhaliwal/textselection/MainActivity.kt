package com.dhaliwal.textselection

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import com.dhaliwal.textselection.ui.theme.TextSelectionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TextSelectionTheme {
                GreetingPreview()
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun SuperScriptText(
    normalText : String,
    superText : String,
    normalText1 : String,
    subText : String,
    normalFontSize : TextUnit = MaterialTheme.typography.titleLarge.fontSize,
    shiftedFontSize : TextUnit = MaterialTheme.typography.titleMedium.fontSize
    ){
    Column{
        Text(buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontSize = normalFontSize
                )
            ){
                append(normalText)
            }
            withStyle(
                style = SpanStyle(
                    fontSize = shiftedFontSize,
                    fontWeight = FontWeight.Normal,
                    baselineShift = BaselineShift.Superscript
                )
            ){
                append(superText)
            }
        })
        Text(
            buildAnnotatedString({
                withStyle(
                    style = SpanStyle(
                        fontSize = normalFontSize,
                        fontWeight = FontWeight.Normal
                    )
                ){
                    append(normalText1)
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = shiftedFontSize,
                        fontWeight = FontWeight.Normal,
                        baselineShift = BaselineShift.Subscript
                    )
                ){
                    append(subText)
                }
            })
        )
    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Surface(modifier = Modifier.fillMaxSize().systemBarsPadding()) {
        SuperScriptText("Sukhmeet", "Singh", "Dhaliwal" , "Sukhmeet");
    }
}