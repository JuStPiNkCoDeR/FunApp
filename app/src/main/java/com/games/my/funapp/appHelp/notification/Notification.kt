package com.games.my.funapp.appHelp.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Context.NOTIFICATION_SERVICE
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.games.my.funapp.AppError
import com.games.my.funapp.appHelp.AppHelp
import java.util.*

/** @author -> JustPinkcoder
 *  @param context context of application(shouldn't be null)
 *  @param config needed notification configuration(child of NotificationConfig interface)
 *  @constructor tries to create notification channel if it available and checks context value
 *  @throws AppError
 *
 *  Use to control and realise app notifications*/
class Notification(private val context: Context?, private val config: NotificationConfig): AppHelp {
    override val atDayOfWeekAndTime: List<Calendar> = listOf()
    private var id: Int = 0
    private val builder: NotificationCompat.Builder? =
        if (context != null)
        NotificationCompat.Builder(context, config.id)
            .setSmallIcon(config.icon)
            .setContentTitle(context.getString(config.title))
        else null
    private var description: String = ""

    init {
        if (context != null)
            createNotificationChannel()
        else throw AppError("Context не найден!\n${this::class.qualifiedName}")
    }

    override fun release() {
        if (context != null && builder != null) {
            builder.setContentText(description)
            NotificationManagerCompat.from(context).notify(id, builder.build())
            id++
        }
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = context?.getString(config.channelName)
            val channel = NotificationChannel(config.id, name, config.channelImportance!!)
            channel.description = context?.getString(config.channelDescription)
            channel.enableLights(true)
            channel.enableVibration(true)
            val notificationManager: NotificationManager = context?.getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    fun setDescription(desc: String) {
        description = desc
    }

}