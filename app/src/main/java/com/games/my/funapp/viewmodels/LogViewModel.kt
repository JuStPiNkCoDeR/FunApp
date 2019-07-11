package com.games.my.funapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.games.my.funapp.data.Log
import com.games.my.funapp.data.LogsRepository

class LogViewModel(application: Application): AndroidViewModel(application) {
    private val repository: LogsRepository = LogsRepository(application)
    private var allLogs: LiveData<List<Log>> = repository.getAllLogs()

    fun insert(log: Log) {
        repository.insert(log)
    }

    fun update(log: Log) {
        repository.update(log)
    }

    fun delete(log: Log) {
        repository.delete(log)
    }

    fun deleteAllLogs() {
        repository.deleteAllLogs()
    }

    fun getAllLogs(): LiveData<List<Log>> {
       return allLogs
    }
}