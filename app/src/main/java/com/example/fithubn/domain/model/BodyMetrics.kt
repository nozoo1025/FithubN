package com.example.fithubn.domain.model

import java.time.LocalDate

data class BodyMetrics(
    val id: Int,
    val height: Double,
    val weight: Double,
    val createdAt: LocalDate
)