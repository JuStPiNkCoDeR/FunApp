package com.games.my.funapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "logs_table")
data class Log(
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    var message: String,
    var time: String
)