package com.games.my.funapp.data.apphelp

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "app_help")
data class Help(
    val name: Int,
    val layout: Int,
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null
)