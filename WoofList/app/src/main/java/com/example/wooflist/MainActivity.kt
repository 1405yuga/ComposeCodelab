package com.example.wooflist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
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
            }
        }
    }
}

@Composable
fun WoofItemCard(woof: Woof, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Row {
            Image(
                painter = painterResource(woof.imageResourceId),
                contentDescription = stringResource(woof.name),
                contentScale = ContentScale.Inside,
                modifier = modifier.weight(1f)
            )
            Column(
                modifier = modifier
                    .padding(horizontal = 8.dp, vertical = 4.dp)
                    .weight(2f)
            ) {
                Text(text = stringResource(woof.name))
                Text(text = "${woof.age} years old")
            }
        }
    }
}

@Composable
fun WoofListApp(modifier: Modifier = Modifier) {
}

@Preview(showBackground = true)
@Composable
fun WoofListPreview() {
    WoofItemCard(WoofListData.dataList[0])
}