package com.example.fithubn.domain.repository

import com.example.fithubn.domain.model.BodyMetrics

interface BodyMetricsRepository {

    suspend fun addBodyMetrics(bodyMetrics: BodyMetrics)

    suspend fun getBodyMetricsList(): List<BodyMetrics>

    suspend fun updateBodyMetrics(bodyMetrics: BodyMetrics)

    suspend fun deleteBodyMetrics(bodyMetrics: BodyMetrics)
}