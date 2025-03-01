package com.example.unscramble.data

val MAX_NO_OF_WORDS = 10
val SCORE_VALUE = 10
val allWords = setOf(
    "at",
    "sea",
    "home",
    "arise",
    "banana",
    "android",
    "birthday",
    "briefcase",
    "motorcycle",
)

private val wordLengthMap: Map<Int, String> = allWords.associateBy({ it.length }, { it })

internal fun getUnscrambledWord(scrambledWord: String) = wordLengthMap[scrambledWord.length] ?: ""