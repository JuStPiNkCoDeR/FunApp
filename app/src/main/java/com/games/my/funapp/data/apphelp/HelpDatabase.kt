package com.games.my.funapp.data.apphelp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.games.my.funapp.R
import com.games.my.funapp.data.Goal
import com.games.my.funapp.utils.ioThread

@Database(entities = [Help::class, Notification::class, Goal::class], version = 1)
abstract class HelpDatabase: RoomDatabase() {
    abstract fun helpDao(): HelpDAO

    companion object {
        @Volatile
        private var instance :HelpDatabase? = null
        private val initValues: List<Help> = listOf(
            Help(R.string.app_help_notification, R.layout.app_help_notification)
        )

        fun getInstance(context: Context): HelpDatabase {
            return instance ?: synchronized(this) {
                Room.databaseBuilder(context.applicationContext,
                    HelpDatabase::class.java,
                    "app_help_database.db")
                    .fallbackToDestructiveMigration()
                    .addCallback(object : RoomDatabase.Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            ioThread {
                                getInstance(context).helpDao().insert(initValues)
                            }
                        }
                    })
                    .build().also { instance = it }
            }
        }
    }
}