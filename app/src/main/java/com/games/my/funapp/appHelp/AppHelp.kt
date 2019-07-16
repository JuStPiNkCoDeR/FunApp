package com.games.my.funapp.appHelp

import android.content.Context
import com.games.my.funapp.appHelp.notification.GoalConfig
import com.games.my.funapp.appHelp.notification.Notification

class AppHelp(private val context: Context?, private val notification: Boolean) {
    private var notifyBuilder: Notification? = null

    init {
        if (notification) notifyBuilder = Notification(context, GoalConfig())
    }

    fun notify(desc: String) {
        notifyBuilder?.notify(desc)
    }
}