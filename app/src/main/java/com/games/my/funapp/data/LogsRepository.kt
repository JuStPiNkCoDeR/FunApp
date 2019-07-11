package com.games.my.funapp.data

import android.app.Application
import androidx.lifecycle.LiveData
import com.games.my.funapp.utils.ioThread

class LogsRepository(application: Application) {
    private val logDAO: LogDAO
    private val logs: LiveData<List<Log>>

    init {
        val database = LogsDatabase.getInstance(application)
        logDAO = database.logDAO()
        logs = logDAO.getAllLogs()
    }

    fun getAllLogs(): LiveData<List<Log>> {
        return logs
    }

    fun insert(log: Log) {
        ioThread {
            logDAO.insert(log)
        }
    }

    fun update(log: Log) {
        ioThread {
            logDAO.update(log)
        }
    }

    fun delete(log: Log) {
        ioThread {
            logDAO.delete(log)
        }
    }

    fun deleteAllLogs() {
        ioThread {
            logDAO.deleteAllLogs()
        }
    }
}