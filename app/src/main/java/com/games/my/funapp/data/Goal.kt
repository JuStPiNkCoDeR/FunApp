package com.games.my.funapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.games.my.funapp.appHelp.AppHelp

@Entity(tableName = "goals_table")
data class Goal(
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null,
    val priority: Int,
    val startDateStamp: Long,
    val finishDataStamp: Long,
    val task: String,
    val isHelpNeeded: Boolean = false,
    val helpConfig: AppHelp? = null
)