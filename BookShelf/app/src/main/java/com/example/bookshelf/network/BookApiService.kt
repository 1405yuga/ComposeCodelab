package com.example.bookshelf.network

import com.example.bookshelf.data.BookResponse
import retrofit2.http.GET

interface BookApiService {
    @GET("volumes?q=jazz+history")
    suspend fun getBooksResponse(): BookResponse
}