package com.example.fithubn.presentation.bodymetricslist

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.fithubn.R
import com.example.fithubn.domain.model.BodyMetrics
import com.example.fithubn.presentation.bodymetricslist.components.BodyMetricsItem
import com.example.fithubn.presentation.bodymetricslist.components.FullScreenInputDialog
import com.example.fithubn.presentation.bodymetricslist.viewmodel.BodyMetricsListEffect
import com.example.fithubn.presentation.bodymetricslist.viewmodel.BodyMetricsListEvent
import com.example.fithubn.presentation.bodymetricslist.viewmodel.BodyMetricsViewModel
import com.example.fithubn.presentation.util.use

@Composable
fun BodyMetricsListScreen(
    viewModel: BodyMetricsViewModel = hiltViewModel()
) {
    val (state, effectFlow, dispatch) = use(viewModel)

    FullScreenInputDialog()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    dispatch(BodyMetricsListEvent.ShowAddBodyMetricsDialog)
                },
                content = {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = null
                    )
                }
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            if (state.bodyMetricsList.isEmpty()) {
                NoDataAvailableUI()
            } else {
                BodyMetricsList(state.bodyMetricsList)
            }
        }
    }

    LaunchedEffect(effectFlow) {
        effectFlow.collect { effect ->
            when (effect) {
                is BodyMetricsListEffect.ShowAddBodyMetricsDialog -> {

                }
            }
        }
    }
}

@Composable
fun BodyMetricsList(bodyMetricsList: List<BodyMetrics>) {
    LazyColumn {
        items(
            items = bodyMetricsList,
            key = { it.id }
        ) { bodyMetrics ->
            BodyMetricsItem(
                bodyMetrics = bodyMetrics,
                modifier = Modifier.fillMaxWidth()
            )
            if (bodyMetrics != bodyMetricsList.last()) {
                Divider()
            }
        }
    }
}

@Composable
fun NoDataAvailableUI() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = Icons.Default.VisibilityOff,
                contentDescription = null
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(text = stringResource(R.string.no_data_available))
        }
    }
}