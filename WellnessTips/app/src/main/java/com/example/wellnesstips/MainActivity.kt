package com.example.wellnesstips

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wellnesstips.data.Tip
import com.example.wellnesstips.data.TipRepo
import com.example.wellnesstips.ui.theme.WellnessTipsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WellnessTipsTheme {
                WellnessTipsApp()
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
fun TipItemCard(
    tip: Tip,
    index: Int,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    Card(
        modifier = modifier.fillMaxWidth(),
        onClick = { expanded = !expanded }
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = modifier
                .fillMaxWidth()
                .padding(12.dp)
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
        ) {
            Text(
                text = "Day ${index + 1}",
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = stringResource(tip.title),
                style = MaterialTheme.typography.displaySmall
            )
            Image(
                painter = painterResource(tip.image),
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )
            if (expanded) {
                Text(
                    text = stringResource(tip.description),
                    style = MaterialTheme.typography.displayMedium
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WellnessTipsApp() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "30 Days Of Wellness")
                },
                modifier = Modifier
            )
        }
    ) { it ->
        LazyColumn(
            contentPadding = it,
            modifier = Modifier
                .padding(
                    horizontal = 12.dp
                ),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            itemsIndexed(TipRepo.load30DayTips()) { index, tip ->
                TipItemCard(tip = tip, index = index)
            }
        }
    }
}
