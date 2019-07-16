package com.games.my.funapp

import com.games.my.funapp.data.Log
import com.games.my.funapp.viewmodels.LogViewModel
import java.text.SimpleDateFormat
import java.util.*

class AppError(text: String): Throwable() {
    private var fullMessage: String = text + "\n"

    init {
        for (x in stackTrace) fullMessage += "\n$x"
    }

    fun show(logsViewModel: LogViewModel) {
        logsViewModel.insert(Log(null, fullMessage, SimpleDateFormat("dd.MM.yy HH:mm:ss").format(Date())))
    }
}