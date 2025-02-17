package com.example.proffesionlist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.proffesionlist.data.DataSource
import com.example.proffesionlist.data.Profession
import com.example.proffesionlist.ui.theme.ProffesionListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProffesionListTheme {
                ProfessionListApp()
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ProfessionListPreview() {
    ProfessionListApp()
}

@Composable
fun ProfessionList(modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.padding(
            horizontal = 8.dp,
            vertical = 8.dp
        )
    ) {
        items(items = DataSource.topics) { profession ->
            ProfessionCard(profession = profession)
        }
    }
}

@Composable
fun ProfessionCard(profession: Profession, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .wrapContentHeight()
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(profession.imageResource),
                contentDescription = stringResource(profession.nameResource),
                modifier = modifier
                    .weight(1f),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = modifier
                    .align(Alignment.CenterVertically)
                    .weight(2f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(profession.nameResource),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(
                        bottom = 8.dp
                    )
                )

                Row {
                    Image(
                        painter = painterResource(R.drawable.baseline_grain_24),
                        contentDescription = null,
                        modifier = Modifier.padding(
                            end = 8.dp
                        )
                    )
                    Text(
                        text = "${profession.score}",
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
            }
        }
    }
}

@Composable
fun ProfessionListApp() {
    Surface(
        modifier = Modifier
            .statusBarsPadding()
    ) {
        ProfessionList()
    }
}
