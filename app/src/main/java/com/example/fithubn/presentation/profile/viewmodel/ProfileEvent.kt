package com.example.fithubn.presentation.profile.viewmodel

sealed class ProfileEvent {
    data class OnNameChanged(val name: String) : ProfileEvent()
    data class OnDateOfBirthChanged(val dateOfBirth: String) : ProfileEvent()
    data class OnBioChanged(val bio: String) : ProfileEvent()
    object OnSaveClicked : ProfileEvent()
}
