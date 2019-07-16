package com.games.my.funapp.appHelp.notification

import android.app.NotificationManager
import android.os.Build
import com.games.my.funapp.R

class GoalConfig: NotificationConfig {
    override val id: String
        get() = "goal"
    override val icon: Int
        get() = R.drawable.ic_event_note
    override val title: Int
        get() = R.string.notification_goal_title
    override val channelName: Int
        get() = R.string.notification_channel_name_for_goals
    override val channelImportance: Int?
        get() = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) NotificationManager.IMPORTANCE_HIGH else null
    override val channelDescription: Int
        get() = R.string.notification_goal_channel_desc
}