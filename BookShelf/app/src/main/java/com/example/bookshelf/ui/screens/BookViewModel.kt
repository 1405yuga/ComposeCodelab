package com.example.bookshelf.ui.screens

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.bookshelf.BookShelfApplication
import com.example.bookshelf.data.BookRepository
import kotlinx.coroutines.launch

class BookViewModel(
    private val bookRepository: BookRepository
) : ViewModel() {
    fun getBooks() {
        viewModelScope.launch {
            try {
                val list = bookRepository.getBooksList()
                Log.d("List result", "Result: ${list.size}")
            } catch (e: Exception) {
                e.printStackTrace()
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