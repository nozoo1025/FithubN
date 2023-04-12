package com.example.fithubn.data.local.db.dao.bodymetrics

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface BodyMetricsDao {

    @Insert
    suspend fun insert(bodyMetrics: BodyMetricsEntity)

    @Query("SELECT * FROM body_metrics")
    suspend fun getAll(): List<BodyMetricsEntity>

    @Query("SELECT * FROM body_metrics WHERE id = :id")
    suspend fun getById(id: Int): BodyMetricsEntity

    @Update
    suspend fun update(bodyMetrics: BodyMetricsEntity)

    @Query("DELETE FROM body_metrics WHERE id = :id")
    suspend fun deleteById(id: Int)
}