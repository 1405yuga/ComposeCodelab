package com.example.bookshelf.data

import com.example.bookshelf.network.BookApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val bookRepository: BookRepository
}

class DefaultContainer : AppContainer {
    private val baseUrl = "https://www.googleapis.com/books/v1/"
    private val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(Json {
            ignoreUnknownKeys = true
        }.asConverterFactory("application/json".toMediaType()))
        .build()
    private val retrofitService: BookApiService by lazy {
        retrofit.create(BookApiService::class.java)
    }
    override val bookRepository: BookRepository by lazy {
        NetworkBookRepository(retrofitService)
    }

}