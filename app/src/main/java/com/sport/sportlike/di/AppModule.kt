package com.sport.sportlike.di

import android.content.Context
import androidx.room.Room
import com.sport.sportlike.api.ApiService
import com.sport.sportlike.api.SportDatabase
import com.sport.sportlike.utils.Constants
import com.sport.sportlike.utils.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideBaseUrl() = Constants.BASE_URL

    @Provides
    @Singleton
    fun provideRetrofitInstance(BASE_URL: String): ApiService =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

    @Singleton
    @Provides
    fun provideSportDataBase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context, SportDatabase
        ::class.java,
        DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun provideToDoDao(
        db: SportDatabase
    ) = db.sportDao()
}