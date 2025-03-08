package com.example.bookshelf.data

import com.example.bookshelf.network.BookApiService

interface BookRepository {
    suspend fun getBooksList(): List<Book>
}

class NetworkBookRepository(
    private val bookApiService: BookApiService
) : BookRepository {
    override suspend fun getBooksList(): List<Book> {
        return bookApiService.getBooksResponse().items
    }

}