package com.dhaliwal.roomdb.db_files

import androidx.room.Dao
import androidx.room.Query

@Dao
interface PersonDao {
    @Query("SELECT * FROM person")
    suspend fun getAllData() : List<Person>
}