package com.example.wellnesstips

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.wellnesstips.ui.theme.WellnessTipsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WellnessTipsTheme {
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WellnessPreview() {
    WellnessTipsTheme {
        WellnessTipsApp()
    }
}

@Composable
fun WellnessTipsApp() {
    TODO("Not yet implemented")
}
