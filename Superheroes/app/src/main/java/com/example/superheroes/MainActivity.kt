package com.example.superheroes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroes.data.Hero
import com.example.superheroes.data.HeroesRepository
import com.example.superheroes.ui.theme.Shapes
import com.example.superheroes.ui.theme.SuperheroesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SuperheroesTheme {

            }
        }
    }
}

@Composable
fun HeroItemCard(
    hero: Hero,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()

    ) {
        Row(
            modifier = modifier
                .padding(16.dp)
                .height(72.dp)
        ) {
            Column(
                modifier = modifier
                    .weight(2f)
            ) {
                Text(
                    text = stringResource(hero.nameRes),
                    style = MaterialTheme.typography.displaySmall
                )
                Text(
                    text = stringResource(hero.descriptionRes),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Image(
                painter = painterResource(hero.imageRes),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = modifier
                    .weight(1f)
                    .clip(shape = Shapes.medium)
                    .size(72.dp)
            )
        }
    }

}

@Composable
fun HeroApp(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier) { it ->
        LazyColumn(
            contentPadding = it,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = modifier
                .statusBarsPadding()
                .safeContentPadding()
                .padding(horizontal = 16.dp)
        ) {
            items(HeroesRepository.heroes) { hero ->
                HeroItemCard(hero = hero, modifier = modifier)
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun SuperheroesPreview() {
    SuperheroesTheme {
        HeroApp()
    }
}