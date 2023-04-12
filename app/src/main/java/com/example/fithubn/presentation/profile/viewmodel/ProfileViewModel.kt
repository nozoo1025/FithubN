package com.example.fithubn.presentation.profile.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fithubn.R
import com.example.fithubn.domain.model.UserProfile
import com.example.fithubn.domain.repository.UserProfileRepository
import com.example.fithubn.presentation.util.UnidirectionalViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val userProfileRepository: UserProfileRepository
) : ViewModel(),
    UnidirectionalViewModel<ProfileEvent, ProfileEffect, ProfileState> {

    private val _state = MutableStateFlow(ProfileState())
    override val state: StateFlow<ProfileState> = _state.asStateFlow()

    private val _effect = MutableSharedFlow<ProfileEffect>()
    override val effect: Flow<ProfileEffect> = _effect.asSharedFlow()

    init {
        getUserProfile()
    }

    override fun event(event: ProfileEvent) {
        when (event) {
            is ProfileEvent.OnNameChanged -> {
                onNameChanged(event.name)
            }
            is ProfileEvent.OnDateOfBirthChanged -> {
                onDateOfBirthChanged(event.dateOfBirth)
            }
            is ProfileEvent.OnBioChanged -> {
                onBioChanged(event.bio)
            }
            is ProfileEvent.OnSaveClicked -> {
                onSaveClicked()
            }
        }
    }

    private fun getUserProfile() {
        viewModelScope.launch {
            val userProfile = userProfileRepository.getUserProfile()

            _state.value = _state.value.copy(
                name = userProfile.name,
                dateOfBirth = userProfile.dateOfBirth.toString(),
                bio = userProfile.bio
            )
        }
    }

    private fun onNameChanged(name: String) {
        _state.value = _state.value.copy(name = name)
    }

    private fun onDateOfBirthChanged(dateOfBirth: String) {
        _state.value = _state.value.copy(dateOfBirth = dateOfBirth)
    }

    private fun onBioChanged(bio: String) {
        _state.value = _state.value.copy(bio = bio)
    }

    private fun onSaveClicked() {
        viewModelScope.launch {
            userProfileRepository.updateUserProfile(
                UserProfile(
                    name = _state.value.name,
                    dateOfBirth = LocalDate.of(1999, 1, 1),
                    bio = _state.value.bio
                )
            )
            _effect.emit(ProfileEffect.ShowSnackbar(R.string.snackbar_update_body_metrics))
        }
    }
}