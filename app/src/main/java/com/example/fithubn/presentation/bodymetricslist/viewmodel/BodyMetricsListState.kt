package com.example.fithubn.presentation.bodymetricslist.viewmodel

import com.example.fithubn.domain.model.BodyMetrics

data class BodyMetricsListState(
    val bodyMetricsList: List<BodyMetrics> = emptyList()
)
