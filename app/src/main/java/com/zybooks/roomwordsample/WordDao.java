package com.zybooks.roomwordsample;

// A DAO (data access object) validates your SQL at compile-time and
// associates it with a method.

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

// WordDao is an interface (DAO must be interfaces)
@Dao
public interface WordDao {

    // allowing the insert of the same word multiple times by passing a
    // conflict resolution strategy
    @Insert( onConflict = OnConflictStrategy.IGNORE)
    void insert (Word word);

    @Query("DELETE FROM word_table")
    void deleteAll();

    @Query("SELECT * FROM word_table ORDER BY word ASC")
    LiveData<List<Word>> getAlphabetizedWords();
}
