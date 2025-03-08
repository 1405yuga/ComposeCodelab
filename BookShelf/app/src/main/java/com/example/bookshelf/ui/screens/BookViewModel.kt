package com.example.bookshelf.ui.screens

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.bookshelf.BookShelfApplication
import com.example.bookshelf.data.Book
import com.example.bookshelf.data.BookRepository
import kotlinx.coroutines.launch

sealed interface BooksUiState {
    data class Success(val booksList: List<Book>) : BooksUiState
    object Error : BooksUiState
    object Loading : BooksUiState
}

class BookViewModel(
    private val bookRepository: BookRepository
) : ViewModel() {

    var booksUiState: BooksUiState by mutableStateOf(BooksUiState.Loading)
        private set

    fun getBooks() {
        booksUiState = BooksUiState.Loading
        viewModelScope.launch {
            booksUiState = try {
                val list = bookRepository.getBooksList()
                Log.d("List result", "Result: ${list.size}")
                BooksUiState.Success(list)
            } catch (e: Exception) {
                e.printStackTrace()
                BooksUiState.Error
            }
        }
    }

    init {
        getBooks()
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as BookShelfApplication)
                val booksRepository = application.container.bookRepository
                BookViewModel(bookRepository = booksRepository)
            }
        }
    }

}