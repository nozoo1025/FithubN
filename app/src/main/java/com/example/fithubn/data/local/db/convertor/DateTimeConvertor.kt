package com.example.fithubn.data.local.db.convertor

import androidx.room.TypeConverter
import java.time.LocalDate

class DateTimeConvertor {

    @TypeConverter
    fun fromTimestamp(value: Long?): LocalDate? {
        return value?.let { LocalDate.ofEpochDay(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: LocalDate?): Long? {
        return date?.toEpochDay()
    }
}