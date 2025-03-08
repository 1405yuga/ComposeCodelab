package com.example.bookshelf.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.example.bookshelf.R
import com.example.bookshelf.data.Book
import com.example.bookshelf.data.ImageLinks
import com.example.bookshelf.data.VolumeInfo

@Composable
fun BooksGridScreen(
    booksList: List<Book>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(150.dp),
        modifier = modifier.padding(horizontal = 4.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(items = booksList, key = { book -> book.id }) { book ->
            BookShelfCard(
                book = book,
                modifier = modifier
                    .fillMaxWidth()
                    .aspectRatio(0.7f)
            )
        }
    }
}

@Composable
fun BookShelfCard(book: Book, modifier: Modifier = Modifier) {
    Card(
        shape = RoundedCornerShape(4.dp),
        modifier = modifier
    ) {
        AsyncImage(
            model = ImageRequest.Builder(context = LocalContext.current)
                .data(book.volumeInfo.imageLinks?.thumbnail)
                .crossfade(true)
                .build(),
            placeholder = painterResource(R.drawable.loading_img),
            error = painterResource(R.drawable.ic_broken_image),
            contentDescription = book.volumeInfo.title
        )
    }
}

@Composable
@Preview
fun BookShelfCardPreview() {
    BookShelfCard(
        Book(
            id = "12",
            volumeInfo = VolumeInfo("some title", imageLinks = ImageLinks("com.a"))
        )
    )
}

@Composable
@Preview
fun BookShelfGridPreview() {
    BooksGridScreen(
        List(10) {
            Book(
                id = "12",
                volumeInfo = VolumeInfo("some title", imageLinks = ImageLinks("com.a"))
            )
        }
    )
}