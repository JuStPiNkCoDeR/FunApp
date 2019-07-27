package com.games.my.funapp.data.Converters

import androidx.room.TypeConverter
import com.google.gson.Gson

class ListConverter {

    @TypeConverter
    fun fromList(items: List<Int>): String {
        return Gson().toJson(items)
    }

    fun toList(item: String): List<Int>? {
        val objects = Gson().fromJson(item, Array<Int>::class.java) as Array<Int>
        return objects.toList()
    }
}