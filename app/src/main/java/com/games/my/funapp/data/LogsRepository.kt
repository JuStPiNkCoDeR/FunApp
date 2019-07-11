package com.games.my.funapp.data

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData

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
        InsertAsync(logDAO).execute(log)
    }

    fun update(log: Log) {
        UpdateAsync(logDAO).execute(log)
    }

    fun delete(log: Log) {
        DeleteAsync(logDAO).execute(log)
    }

    fun deleteAllLogs() {
        DeleteAllAsync(logDAO).execute()
    }


    private class InsertAsync internal constructor(private val asyncDAO: LogDAO): AsyncTask<Log, Void, Void>() {
        override fun doInBackground(vararg params: Log): Void? {
            asyncDAO.insert(params[0])
            return null
        }
    }

    private class UpdateAsync internal constructor(private val asyncDAO: LogDAO): AsyncTask<Log, Void, Void>() {
        override fun doInBackground(vararg params: Log): Void? {
            asyncDAO.update(params[0])
            return null
        }
    }

    private class DeleteAsync internal constructor(private val asyncDAO: LogDAO): AsyncTask<Log, Void, Void>() {
        override fun doInBackground(vararg params: Log): Void? {
            asyncDAO.delete(params[0])
            return null
        }
    }

    private class DeleteAllAsync internal constructor(private val asyncDAO: LogDAO): AsyncTask<Void, Void, Void>() {
        override fun doInBackground(vararg params: Void): Void? {
            asyncDAO.deleteAllLogs()
            return null
        }
    }
}