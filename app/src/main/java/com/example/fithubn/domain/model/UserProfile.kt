package com.example.fithubn.domain.model

import java.time.LocalDate

data class UserProfile(
    val name: String,
    val dateOfBirth: LocalDate,
    val bio: String
)
