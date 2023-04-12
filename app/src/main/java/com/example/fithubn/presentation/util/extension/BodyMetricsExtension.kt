package com.example.fithubn.presentation.util.extension

import com.example.fithubn.domain.model.BodyMetrics
import kotlin.math.pow
import kotlin.math.roundToInt

val BodyMetrics.bmi: Double
    get() = ((weight / (height / 100).pow(2)) * 100.0).roundToInt() / 100.0