package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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

val artList = listOf(
    Art(
        imageResource = R.drawable.starry,
        artTitle = "The Starry Night",
        artistName = "Vincent van Gogh",
        yearPainted = 1889
    ),
    Art(
        imageResource = R.drawable.ganpati,
        artTitle = "Ganesha",
        artistName = "Karan Gaikwad",
        yearPainted = 2022
    ),
    Art(
        imageResource = R.drawable.images,
        artTitle = "London Bridge",
        artistName = "Claude Monet",
        yearPainted = 1871
    ),
)

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
        Surface(
            color = MaterialTheme.colorScheme.secondaryContainer,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(12.dp)) {
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
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.onSecondaryContainer,
            contentColor = MaterialTheme.colorScheme.onSecondary
        ),
        modifier = modifier.padding(horizontal = 8.dp)
    ) {
        Text(text = text)
    }
}

@Composable
fun ArtSpaceLayout(modifier: Modifier = Modifier) {
    var count by remember { mutableIntStateOf(0) }
    val currentArt = artList[kotlin.math.abs(count) % artList.size]
    Column(
        modifier =
        modifier
            .fillMaxSize()
            .padding(16.dp)
            .statusBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ArtImageAndInfo(
            imageResource = currentArt.imageResource,
            title = currentArt.artTitle,
            artist = currentArt.artistName,
            year = currentArt.yearPainted,
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
                onClickAction = { count++ },
                modifier = modifier.weight(1f)
            )

            ActionButton(
                text = "Next",
                onClickAction = { count-- },
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