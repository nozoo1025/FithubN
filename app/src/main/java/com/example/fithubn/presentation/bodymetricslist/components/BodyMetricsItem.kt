package com.example.fithubn.presentation.bodymetricslist.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowRight
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fithubn.domain.model.BodyMetrics
import com.example.fithubn.presentation.util.extension.bmi
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

@Composable
fun BodyMetricsItem(bodyMetrics: BodyMetrics, modifier: Modifier = Modifier) {
    ListItem(
        headlineContent = {
            Text(
                bodyMetrics.createdAt.format(
                    DateTimeFormatter.ofLocalizedDate(
                        FormatStyle.LONG
                    )
                )
            )
        },
        supportingContent = {
            Row {
                Text("${bodyMetrics.height} cm")
                Spacer(modifier = Modifier.width(4.dp))
                Text("/")
                Spacer(modifier = Modifier.width(4.dp))
                Text("${bodyMetrics.weight} kg")
                Spacer(modifier = Modifier.width(4.dp))
                Text("/")
                Spacer(modifier = Modifier.width(4.dp))
                Text("BMI: ${bodyMetrics.bmi}")
            }
        },
        leadingContent = {
            Icon(
                imageVector = Icons.Default.ArrowUpward,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.error
            )
        },
        trailingContent = {
            Icon(
                imageVector = Icons.Default.ArrowRight,
                contentDescription = null
            )
        },
        modifier = modifier
    )
}

@Preview
@Composable
fun BodyMetricsItemPreview() {
    BodyMetricsItem(
        bodyMetrics = BodyMetrics(
            id = 1,
            weight = 80.0,
            height = 180.0,
            createdAt = LocalDate.now()
        ),
        modifier = Modifier.fillMaxWidth()
    )
}