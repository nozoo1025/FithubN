package com.example.fithubn.data.repository

import com.example.fithubn.data.local.db.dao.bodymetrics.BodyMetricsDao
import com.example.fithubn.data.mapper.toBodyMetrics
import com.example.fithubn.data.mapper.toBodyMetricsEntity
import com.example.fithubn.domain.model.BodyMetrics
import com.example.fithubn.domain.repository.BodyMetricsRepository
import javax.inject.Inject

class BodyMetricsRepositoryImpl @Inject constructor(
    private val bodyMetricsDao: BodyMetricsDao
) : BodyMetricsRepository {

    override suspend fun addBodyMetrics(bodyMetrics: BodyMetrics) {
        bodyMetricsDao.insert(bodyMetrics.toBodyMetricsEntity())
    }

    override suspend fun getBodyMetricsList(): List<BodyMetrics> {
        return bodyMetricsDao.getAll().toBodyMetrics()
    }

    override suspend fun updateBodyMetrics(bodyMetrics: BodyMetrics) {
        bodyMetricsDao.update(bodyMetrics.toBodyMetricsEntity())
    }

    override suspend fun deleteBodyMetrics(bodyMetrics: BodyMetrics) {
        bodyMetricsDao.deleteById(bodyMetrics.id)
    }
}