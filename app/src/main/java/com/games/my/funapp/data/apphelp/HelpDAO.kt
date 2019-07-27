package com.games.my.funapp.data.apphelp

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface HelpDAO {
    @Insert
    fun insert(item: Help)

    @Insert
    fun insert(items: List<Help>)

    @Update
    fun update(item: Help)

    @Delete
    fun delete(item: Help)

    @Query("DELETE FROM app_help")
    fun deleteAll()

    @Query("SELECT * FROM app_help")
    fun getAll(): LiveData<List<Help>>
}