package com.example.fithubn.domain.repository

import com.example.fithubn.domain.model.UserProfile

interface UserProfileRepository {

    suspend fun addUserProfile(userProfile: UserProfile)

    suspend fun getUserProfile(): UserProfile

    suspend fun updateUserProfile(userProfile: UserProfile)

    suspend fun deleteUserProfile(userProfile: UserProfile)
}