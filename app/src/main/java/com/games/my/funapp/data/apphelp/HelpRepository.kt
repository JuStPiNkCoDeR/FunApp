package com.games.my.funapp.data.apphelp

import android.app.Application
import androidx.lifecycle.LiveData
import com.games.my.funapp.utils.ioThread

class HelpRepository(application: Application) {
    private val helpDAO: HelpDAO
    private val helps: LiveData<List<Help>>

    init {
        val database = HelpDatabase.getInstance(application)
        helpDAO = database.helpDao()
        helps = helpDAO.getAll()
    }

    fun getAll(): LiveData<List<Help>> {
        return helps
    }

    fun insert(item: Help) {
        ioThread {
            helpDAO.insert(item)
        }
    }

    fun insert(items: List<Help>) {
        ioThread {
            helpDAO.insert(items)
        }
    }

    fun update(item: Help) {
        ioThread {
            helpDAO.update(item)
        }
    }

    fun delete(item: Help) {
        ioThread {
            helpDAO.delete(item)
        }
    }

    fun deleteAll() {
        ioThread {
            helpDAO.deleteAll()
        }
    }
}