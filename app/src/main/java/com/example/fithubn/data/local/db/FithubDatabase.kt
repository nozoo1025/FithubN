package com.example.fithubn.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.fithubn.data.local.db.convertor.DateTimeConvertor
import com.example.fithubn.data.local.db.dao.bodymetrics.BodyMetricsDao
import com.example.fithubn.data.local.db.dao.bodymetrics.BodyMetricsEntity

@Database(
    entities = [
        BodyMetricsEntity::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(DateTimeConvertor::class)
abstract class FithubDatabase : RoomDatabase() {

    abstract fun bodyMetricsDao(): BodyMetricsDao

    companion object {
        const val DATABASE_NAME = "fithubn.db"
    }
}