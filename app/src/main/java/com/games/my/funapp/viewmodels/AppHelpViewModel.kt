package com.games.my.funapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.games.my.funapp.data.apphelp.Help
import com.games.my.funapp.data.apphelp.HelpRepository

class AppHelpViewModel(application: Application): AndroidViewModel(application) {
    private val repository: HelpRepository = HelpRepository(application)
    private var allHelps: LiveData<List<Help>> = repository.getAll()

    fun insert(item: Help) {
        repository.insert(item)
    }

    fun insert(items: List<Help>) {
        repository.insert(items)
    }

    fun update(item: Help) {
        repository.update(item)
    }

    fun delete(item: Help) {
        repository.delete(item)
    }

    fun deleteAll() {
        repository.deleteAll()
    }

    fun getAll(): LiveData<List<Help>> {
        return allHelps
    }
}