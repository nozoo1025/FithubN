package com.example.fithubn.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.fithubn.data.local.db.FithubDatabase
import com.example.fithubn.data.repository.BodyMetricsRepositoryImpl
import com.example.fithubn.data.repository.UserProfileRepositoryImpl
import com.example.fithubn.domain.repository.BodyMetricsRepository
import com.example.fithubn.domain.repository.UserProfileRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideFithubDatabase(app: Application): FithubDatabase {
        return Room.databaseBuilder(
            app,
            FithubDatabase::class.java,
            FithubDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideBodyMetricsRepository(db: FithubDatabase): BodyMetricsRepository {
        return BodyMetricsRepositoryImpl(db.bodyMetricsDao())
    }

    @Provides
    @Singleton
    fun provideUserProfileRepository(@ApplicationContext context: Context): UserProfileRepository {
        return UserProfileRepositoryImpl(context)
    }
}