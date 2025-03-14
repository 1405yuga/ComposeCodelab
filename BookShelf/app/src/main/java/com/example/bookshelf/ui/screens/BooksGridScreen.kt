package com.example.bookshelf.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.bookshelf.R
import com.example.bookshelf.data.Book
import com.example.bookshelf.data.ImageLinks
import com.example.bookshelf.data.VolumeInfo

@Composable
fun BooksGridScreen(
    booksList: List<Book>,
    modifier: Modifier = Modifier
) {
    Log.d("BooksGridScreen", "Bookslist : $booksList")
    LazyVerticalGrid(
        columns = GridCells.Adaptive(150.dp),
        modifier = modifier.padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(items = booksList, key = { book -> book.id }) { book ->
            BookShelfCard(
                book = book
            )
        }
    }
}

@Composable
fun BookShelfCard(book: Book, modifier: Modifier = Modifier) {
    Log.d("BookShelfCard", book.volumeInfo.imageLinks?.thumbnail.toString())
    Card(
        shape = RoundedCornerShape(4.dp),
        modifier = modifier.fillMaxWidth()
    ) {
        Column {
            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(book.volumeInfo.imageLinks?.thumbnail ?: "") // Default empty string
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(R.drawable.loading_img),
                error = painterResource(R.drawable.ic_broken_image),
                contentDescription = book.volumeInfo.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(0.7f) // Properly size the image
            )
            Text(book.volumeInfo.title,
                fontSize = 20.sp,
                modifier = Modifier.padding(4.dp))
        }
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
        List(5) {
            Book(
                id = "$it",
                volumeInfo = VolumeInfo("some title", imageLinks = ImageLinks("com.a"))
            )
        }
    )
}