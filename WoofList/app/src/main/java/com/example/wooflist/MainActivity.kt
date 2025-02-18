package com.example.wooflist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.wooflist.data.Woof
import com.example.wooflist.ui.theme.WoofListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WoofListTheme {
            }
        }
    }
}

@Composable
fun WoofItemCard(woof: Woof, modifier: Modifier = Modifier) {

}

@Composable
fun WoofListApp(modifier: Modifier = Modifier) {
}

@Preview(showBackground = true)
@Composable
fun WoofListPreview() {
}