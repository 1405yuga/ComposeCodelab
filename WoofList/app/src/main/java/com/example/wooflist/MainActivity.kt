package com.example.wooflist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.StringRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
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
    var expanded by remember { mutableStateOf(false) }
    val color by animateColorAsState(
        targetValue = if (expanded) MaterialTheme.colorScheme.tertiaryContainer
        else MaterialTheme.colorScheme.primaryContainer
    )

    //by default: card shape is medium, so not need to set explicitly
    Card(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(horizontal = 8.dp)
    ) {
        Column(
            modifier = Modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )
                .background(color = color)
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
                        text = "${woof.age} years old", style = MaterialTheme.typography.bodyLarge
                    )
                }
                WoofItemButton(
                    expanded = expanded,
                    onClick = { expanded = !expanded },
                    modifier = modifier
                )
            }
            if (expanded) {
                WoofHobby(
                    hobby = woof.hobbies,
                    modifier = Modifier.padding(
                        start = dimensionResource(R.dimen.padding_medium),
                        top = dimensionResource(R.dimen.padding_small),
                        end = dimensionResource(R.dimen.padding_medium),
                        bottom = dimensionResource(R.dimen.padding_medium)
                    )
                )
            }
        }
    }
}

@Composable
fun WoofHobby(
    @StringRes hobby: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(R.string.about),
            style = MaterialTheme.typography.labelSmall
        )
        Text(
            text = stringResource(hobby),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
fun WoofItemButton(expanded: Boolean, onClick: () -> Unit, modifier: Modifier) {
    IconButton(
        onClick = onClick,
        modifier = modifier,
    ) {
        Icon(
            imageVector = if (expanded) {
                Icons.Filled.ExpandMore
            } else {
                Icons.Filled.ExpandLess
            },
            contentDescription = "Expand button",
            tint = MaterialTheme.colorScheme.secondary
        )
    }
}

@Composable
fun WoofListApp(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = { WoofTopAppBar() }
    ) { padding ->
        LazyColumn(
            contentPadding = padding,
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = modifier.statusBarsPadding()
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WoofTopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_woof_logo),
                    contentDescription = null,
                    modifier = Modifier
                        .size(dimensionResource(R.dimen.image_size))
                        .padding(dimensionResource(R.dimen.padding_small))
                )
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.displayLarge
                )
            }
        },
    )
}

@Preview(showBackground = true)
@Composable
fun WoofListDarkPreview() {
    WoofListTheme(darkTheme = true) {
        WoofListApp(modifier = Modifier)
    }
}