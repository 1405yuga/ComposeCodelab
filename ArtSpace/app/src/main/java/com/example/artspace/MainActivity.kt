package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Surface(
            shadowElevation = 4.dp,
            modifier = Modifier
                .padding(top = 8.dp, bottom = 120.dp)
                .weight(1f)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(imageResource), contentDescription = title,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.padding(32.dp)
            )
        }
        Text(
            text = title,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 22.sp,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        Text(
            text = "$artist $year",
            fontSize = 18.sp,
            modifier = Modifier.padding(bottom = 4.dp)
        )
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
        modifier
            .fillMaxSize()
            .padding(16.dp)
            .statusBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ArtImageAndInfo(
            imageResource = R.drawable.ic_launcher_background,
            title = "Art title",
            artist = "some artist",
            year = 1000,
            modifier = modifier
                .weight(1f)
                .padding(bottom = 16.dp)
                .fillMaxWidth()
        )
        Row(
            modifier = modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Bottom
        ) {
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