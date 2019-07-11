package com.games.my.funapp.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface LogDAO {
    @Insert
    fun insert(log: Log)

    @Insert
    fun insert(logs: List<Log>)

    @Update
    fun update(log: Log)

    @Delete
    fun delete(log: Log)

    @Query("DELETE FROM logs_table")
    fun deleteAllLogs()

    @Query("SELECT * FROM logs_table")
    fun getAllLogs(): LiveData<List<Log>>
}