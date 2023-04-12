package com.example.fithubn.presentation.profile.viewmodel

sealed class ProfileEffect {
    data class ShowSnackbar(val messageId: Int) : ProfileEffect()
}