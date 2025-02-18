package com.example.wooflist

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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wooflist.data.Woof
import com.example.wooflist.data.WoofListData
import com.example.wooflist.ui.theme.WoofListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WoofListTheme {
                WoofListApp(modifier = Modifier)
            }
        }
    }
}

@Composable
fun WoofItemCard(woof: Woof, modifier: Modifier = Modifier) {
    //by default: card shape is medium, so not need to set explicitly
    Card(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(horizontal = 8.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Image(
                painter = painterResource(woof.imageResourceId),
                contentDescription = stringResource(woof.name),
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .padding(dimensionResource(R.dimen.padding_small))
                    .size(dimensionResource(R.dimen.image_size))
                    .clip(MaterialTheme.shapes.small)
            )
            Column(
                modifier = modifier
                    .padding(vertical = 4.dp)
                    .weight(2f)
            ) {
                Text(
                    text = stringResource(woof.name),
                    style = MaterialTheme.typography.displayMedium,
                    modifier = Modifier.padding(top = dimensionResource(id = R.dimen.padding_small))
                )
                Text(
                    text = "${woof.age} years old",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}

@Composable
fun WoofListApp(modifier: Modifier = Modifier) {
    Scaffold { it ->
        LazyColumn(
            contentPadding = it,
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = modifier
                .statusBarsPadding()
        ) {
            items(WoofListData.dataList) { woof ->
                WoofItemCard(woof = woof, modifier = modifier)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WoofListPreview() {
    WoofListTheme {
        WoofListApp(modifier = Modifier)
    }
}

@Preview(showBackground = true)
@Composable
fun WoofListDarkPreview() {
    WoofListTheme(darkTheme = true) {
        WoofListApp(modifier = Modifier)
    }
}