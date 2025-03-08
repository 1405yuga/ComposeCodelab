package com.example.bookshelf.data

import kotlinx.serialization.Serializable

@Serializable
data class BookResponse(
    val items: List<Book>
)

@Serializable
data class Book(
    val id: String,
    val volumeInfo: VolumeInfo
)

@Serializable
data class VolumeInfo(
    val title: String,
    val imageLinks: ImageLinks? = ImageLinks("")
)

@Serializable
data class ImageLinks(
    val thumbnail: String
)
