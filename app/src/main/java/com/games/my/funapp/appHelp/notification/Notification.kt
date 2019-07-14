package com.games.my.funapp.appHelp.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.ClipDescription
import android.content.Context
import android.content.Context.NOTIFICATION_SERVICE
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class Notification(private val context: Context, private val config: NotificationConfig) {
    private var id: Int = 0
    private val builder: NotificationCompat.Builder =
        NotificationCompat.Builder(context, config.id)
            .setSmallIcon(config.icon)
            .setContentTitle(context.getString(config.title))

    init {
        createNotificationChannel()
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = context.getString(config.channelName)
            val channel = NotificationChannel(config.id, name, config.channelImportance!!)
            val notificationManager: NotificationManager = context.getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    fun notify(desc: String) {
        builder.setContentText(desc)
        NotificationManagerCompat.from(context).notify(id, builder.build())
    }

}