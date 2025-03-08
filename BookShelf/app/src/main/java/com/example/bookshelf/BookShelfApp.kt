@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.bookshelf

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.bookshelf.ui.data.Book
import com.example.bookshelf.ui.data.ImageLinks
import com.example.bookshelf.ui.data.VolumeInfo
import com.example.bookshelf.ui.screens.BooksGridScreen

@Composable
fun BookShelfApp() {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = { BookTopAppBar(scrollBehavior) }
    ) { innerPadding ->
        Surface(modifier = Modifier.padding(innerPadding)) {
            BooksGridScreen(
                booksList = List(10) { //TODO: replace by data
                    Book(
                        id = "$it", imageLinks = ImageLinks("com.a"),
                        volumeInfo = VolumeInfo("some title")
                    )
                },
                modifier = Modifier
                    .fillMaxSize()
            )
        }
    }
}

@Composable
fun BookTopAppBar(scrollBehavior: TopAppBarScrollBehavior, modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.headlineSmall
            )
        },
        scrollBehavior = scrollBehavior,
        modifier = modifier
    )

}

@Preview
@Composable
fun BookShelfPreview() {
    BookShelfApp()
}
