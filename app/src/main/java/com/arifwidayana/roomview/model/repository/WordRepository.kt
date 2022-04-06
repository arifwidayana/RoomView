package com.arifwidayana.roomview.model.repository

import androidx.annotation.WorkerThread
import com.arifwidayana.roomview.model.Word
import com.arifwidayana.roomview.model.WordDao
import kotlinx.coroutines.flow.Flow

// declares DAO as a private property in the constructor
class WordRepository(private val wordDao: WordDao) {
    // Room executes all query and Flow will notify when data has changed
    val allWords: Flow<List<Word>> = wordDao.getAlphabetizeWords()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(word: Word) {
        wordDao.insert(word)
    }
}