package com.example.fithubn.presentation.bodymetricslist.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fithubn.domain.model.BodyMetrics
import com.example.fithubn.domain.repository.BodyMetricsRepository
import com.example.fithubn.presentation.util.UnidirectionalViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BodyMetricsViewModel @Inject constructor(
    private val bodyMetricsRepository: BodyMetricsRepository,
) : ViewModel(),
    UnidirectionalViewModel<BodyMetricsListEvent, BodyMetricsListEffect, BodyMetricsListState> {

    private val _state = MutableStateFlow(BodyMetricsListState())
    override val state: StateFlow<BodyMetricsListState> = _state.asStateFlow()

    private val _effect = MutableSharedFlow<BodyMetricsListEffect>()
    override val effect: Flow<BodyMetricsListEffect> = _effect.asSharedFlow()

    init {
        viewModelScope.launch {
            _state.value = _state.value.copy(bodyMetricsList = getBodyMetrics())
        }
    }

    override fun event(event: BodyMetricsListEvent) {
        when (event) {
            is BodyMetricsListEvent.ShowAddBodyMetricsDialog -> {
                viewModelScope.launch {
                    _effect.emit(BodyMetricsListEffect.ShowAddBodyMetricsDialog)
                }
            }
        }
    }

    private suspend fun getBodyMetrics(): List<BodyMetrics> {
        return bodyMetricsRepository.getBodyMetricsList()
    }
}