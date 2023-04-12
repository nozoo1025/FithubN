package com.example.fithubn.data.local.db.dao.bodymetrics

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "body_metrics")
data class BodyMetricsEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val height: Double,
    val weight: Double,
    val createdAt: LocalDate
)
