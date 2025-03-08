@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.bookshelf.ui

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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bookshelf.R
import com.example.bookshelf.data.Book
import com.example.bookshelf.data.ImageLinks
import com.example.bookshelf.data.VolumeInfo
import com.example.bookshelf.ui.screens.BookViewModel
import com.example.bookshelf.ui.screens.BooksGridScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookShelfApp() {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = { BookTopAppBar(scrollBehavior) }
    ) { innerPadding ->
        Surface(modifier = Modifier.padding(innerPadding)) {
            val bookViewModel: BookViewModel = viewModel(factory = BookViewModel.Factory)
            BooksGridScreen(
                booksList = List(10) { //TODO: replace by data
                    Book(
                        id = "$it",
                        volumeInfo = VolumeInfo("some title", imageLinks = ImageLinks("com.a"))
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
