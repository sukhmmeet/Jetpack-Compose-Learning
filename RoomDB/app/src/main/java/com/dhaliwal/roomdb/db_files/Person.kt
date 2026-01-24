package com.dhaliwal.roomdb.db_files

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "person")
data class Person(
    @PrimaryKey
    val id : Int,
    val name : String,
    val age : Int
)
