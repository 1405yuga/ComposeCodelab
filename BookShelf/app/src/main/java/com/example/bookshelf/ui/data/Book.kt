package com.example.bookshelf.ui.data

data class Book(
    val id: String,
    val volumeInfo: VolumeInfo,
    val imageLinks: ImageLinks
)

data class VolumeInfo(
    val title: String
)

data class ImageLinks(
    val thumbnail: String
)
