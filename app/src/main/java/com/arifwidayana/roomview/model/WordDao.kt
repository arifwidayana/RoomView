package com.arifwidayana.roomview.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface WordDao {
    // to Get Query from database Word with sort Ascending
    @Query("SELECT * FROM word_table ORDER BY word ASC")
    fun getAlphabetizeWords(): Flow<List<Word>>

    // to Ignore new word if exactly the same as one already in the list
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: Word)

    //to provide SQL query as a string parameter
    @Query("DELETE FROM word_table")
    suspend fun deleteAll()
}