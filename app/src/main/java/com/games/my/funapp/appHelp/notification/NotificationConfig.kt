package com.games.my.funapp.appHelp.notification

interface NotificationConfig {
    val id: String
    val icon: Int
    val title: Int
    val channelName: Int
    val channelImportance: Int?
    val channelDescription: Int
}