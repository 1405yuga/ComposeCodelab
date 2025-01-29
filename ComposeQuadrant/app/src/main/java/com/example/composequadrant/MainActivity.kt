package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Screen()
                }
            }
        }
    }
}

@Composable
fun Screen() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(modifier = Modifier.weight(1f)) {
            QuadrantView(
                title = "Text composable",
                info = "Displays text and follows the recommended Material Design guidelines.",
                modifier = Modifier.weight(1f),
                background = Color(0xFFEADDFF)
            )
            QuadrantView(
                title = "Image composable",
                info = "Creates a composable that lays out and draws a given Painter class object.",
                modifier = Modifier.weight(1f),
                background = Color(0xFFD0BCFF)
            )
        }

        Row(modifier = Modifier.weight(1f)) {
            QuadrantView(
                title = "Row composable",
                info = "A layout composable that places its children in a horizontal sequence.",
                modifier = Modifier.weight(1f),
                background = Color(0xFFB69DF8)
            )
            QuadrantView(
                title = "Column composable",
                info = "A layout composable that places its children in a vertical sequence.",
                modifier = Modifier.weight(1f),
                background = Color(0xFFF6EDFF)
            )
        }
    }
}

@Composable
fun QuadrantView(title: String, info: String, background: Color, modifier: Modifier) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .background(background)
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = info,
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GreetingPreview() {
    ComposeQuadrantTheme {
        Screen()
    }
}