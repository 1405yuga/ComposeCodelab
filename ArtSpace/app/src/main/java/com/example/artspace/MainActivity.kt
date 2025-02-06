package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                ArtSpaceLayout()
            }
        }
    }
}

@Composable
fun ArtImageAndInfo(
    imageResource: Int,
    title: String,
    artist: String,
    year: Int,
    modifier: Modifier = Modifier
) {
    Column {
        Image(painter = painterResource(imageResource), contentDescription = title)
        Text(text = title)
        Text(text = "$artist $year")
    }
}

@Composable
fun ActionButton(
    text: String,
    onClickAction: () -> Unit,
    modifier: Modifier = Modifier
) {

    Button(
        onClick = onClickAction,
        shape = RectangleShape,
        border = BorderStroke(0.5.dp, color = Color.Black),
        modifier = modifier.padding(horizontal = 2.dp)
    ) {
        Text(text = text)
    }
}

@Composable
fun ArtSpaceLayout(modifier: Modifier = Modifier) {
    Column(
        modifier =
        modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ArtImageAndInfo(
            imageResource = R.drawable.ic_launcher_foreground,
            title = "Art title",
            artist = "some artist",
            year = 1000
        )
        Row(modifier = modifier.fillMaxWidth()) {
            ActionButton(
                text = "Previous",
                onClickAction = {},
                modifier = modifier.weight(1f)
            )

            ActionButton(
                text = "Next",
                onClickAction = {},
                modifier = modifier.weight(1f)
            )
        }
    }
}

@Composable
@Preview(
    showBackground = true,
    showSystemUi = true
)
fun ArtSpaceLayoutPreview() {
    ArtSpaceLayout()
}