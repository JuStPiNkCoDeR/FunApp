package com.games.my.funapp.data.apphelp

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.games.my.funapp.data.Goal

@Entity(tableName = "notification_help",
    foreignKeys = [ForeignKey(entity = Goal::class, parentColumns = ["id"], childColumns = ["goalId"])])
data class Notification(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    val goalId: Long? = null,
    val channel_name: Int,
    val description: String
)