package com.example.mycity.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycity.ui.model.Category

@Composable
fun ItemsList(
    imageAndTitleList: List<Pair<Int, String>>,
    onItemClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 12.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        itemsIndexed(imageAndTitleList) { index, item ->
            ItemCard(
                title = item.second,
                image = item.first,
                onClick = {
                    try {
                        Category.valueOf(item.second)
                        onItemClick(item.second)
                    } catch (e: Exception) {
                        onItemClick(index.toString())
                    }

                }
            )
        }
    }
}

@Composable
fun ItemCard(
    image: Int,
    title: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .clickable { onClick() }) {
        Row {
            Image(
                painter = painterResource(image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(end = 8.dp)
                    .size(80.dp)
            )
            Text(
                text = title,
                modifier = modifier
                    .weight(1f)
                    .padding(4.dp),
                fontSize = 22.sp
            )
        }
    }
}