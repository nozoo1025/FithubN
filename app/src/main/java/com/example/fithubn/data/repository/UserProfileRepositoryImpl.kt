package com.example.fithubn.data.repository

import android.content.Context
import android.content.Context.MODE_PRIVATE
import com.example.fithubn.domain.model.UserProfile
import com.example.fithubn.domain.repository.UserProfileRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import java.time.LocalDate
import javax.inject.Inject

class UserProfileRepositoryImpl @Inject constructor(
    @ApplicationContext context: Context
) : UserProfileRepository {

    private val sharedPreferences = context.getSharedPreferences(PREFERENCES_NAME, MODE_PRIVATE)

    override suspend fun addUserProfile(userProfile: UserProfile) {
        sharedPreferences.edit()
            .putString(KEY_NAME, userProfile.name)
            .putLong(KEY_DATE_OF_BIRTH, userProfile.dateOfBirth.toEpochDay())
            .putString(KEY_BIO, userProfile.bio)
            .apply()
    }

    override suspend fun getUserProfile(): UserProfile {
        val name = sharedPreferences.getString(KEY_NAME, "") ?: ""
        val dateOfBirth = LocalDate.ofEpochDay(sharedPreferences.getLong(KEY_DATE_OF_BIRTH, 0))
        val bio = sharedPreferences.getString(KEY_BIO, "") ?: ""

        return UserProfile(name, dateOfBirth, bio)
    }

    override suspend fun updateUserProfile(userProfile: UserProfile) {
        sharedPreferences.edit()
            .putString(KEY_NAME, userProfile.name)
            .putLong(KEY_DATE_OF_BIRTH, userProfile.dateOfBirth.toEpochDay())
            .putString(KEY_BIO, userProfile.bio)
            .apply()
    }

    override suspend fun deleteUserProfile(userProfile: UserProfile) {
        sharedPreferences.edit()
            .remove(KEY_NAME)
            .remove(KEY_DATE_OF_BIRTH)
            .remove(KEY_BIO)
            .apply()
    }

    companion object {
        private const val PREFERENCES_NAME = "com.example.fithubn.user_profile"
        private const val KEY_NAME = "name"
        private const val KEY_DATE_OF_BIRTH = "dateOfBirth"
        private const val KEY_BIO = "bio"
    }
}