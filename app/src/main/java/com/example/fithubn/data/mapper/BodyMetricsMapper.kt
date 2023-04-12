package com.example.fithubn.data.mapper

import com.example.fithubn.data.local.db.dao.bodymetrics.BodyMetricsEntity
import com.example.fithubn.domain.model.BodyMetrics

fun BodyMetricsEntity.toBodyMetrics() = BodyMetrics(
    id = id,
    height = height,
    weight = weight,
    createdAt = createdAt
)

fun List<BodyMetricsEntity>.toBodyMetrics() = map { it.toBodyMetrics() }

fun BodyMetrics.toBodyMetricsEntity() = BodyMetricsEntity(
    id = id,
    height = height,
    weight = weight,
    createdAt = createdAt
)