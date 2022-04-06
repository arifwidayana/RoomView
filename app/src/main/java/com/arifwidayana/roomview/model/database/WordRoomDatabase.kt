package com.arifwidayana.roomview.model.database

import android.content.Context
import androidx.room.*
import com.arifwidayana.roomview.model.Word
import com.arifwidayana.roomview.model.WordDao

//@Database to annotate the class to be Room Database
@Database(entities = [Word::class], version = 1, exportSchema = false)
abstract class WordRoomDatabase : RoomDatabase() {
    abstract fun wordDao() : WordDao

    companion object {
        // Prevent multiple instance of database
        @Volatile
        private var INSTANCE: WordRoomDatabase? = null

        fun getDatabase(context: Context): WordRoomDatabase {
            //if INSTANCE not null will return it, if null then create database
            return INSTANCE?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    WordRoomDatabase::class.java,
                    "word_database").build()
                INSTANCE = instance
                //return instance
                instance
            }
        }
    }
}