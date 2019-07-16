package com.games.my.funapp.data

import android.content.Context
import android.os.AsyncTask
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.games.my.funapp.utils.ioThread
import java.text.SimpleDateFormat
import java.util.*

@Database(entities = [Log::class], version = 1)
abstract class LogsDatabase: RoomDatabase() {
    abstract fun logDAO(): LogDAO

    companion object {
        @Volatile
        private var instance: LogsDatabase? = null

        fun getInstance(context: Context): LogsDatabase {
            return instance?: synchronized(this) {
                Room.databaseBuilder(context.applicationContext,
                    LogsDatabase::class.java,
                    "logs_database.db")
                    .fallbackToDestructiveMigration()
                    .addCallback(object : Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            ioThread {
                                getInstance(context).logDAO().insert(Log(0, "DataBase initialized", SimpleDateFormat("dd.MM.yy HH:mm:ss").format(Date())))
                            }
                        }
                    })
                    .build().also { instance = it }
            }
        }
    }
}