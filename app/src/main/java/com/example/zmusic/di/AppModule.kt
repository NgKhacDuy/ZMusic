package com.example.zmusic.di

import com.example.zmusic.common.Constant
import com.example.zmusic.data.network.ApiInterface
import com.example.zmusic.data.repository.HomeRepositoryImpl
import com.example.zmusic.domain.repository.HomeRepository
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideApiInterface(): ApiInterface {
        return Retrofit.Builder()
            .addConverterFactory(
                Json.asConverterFactory("application/json".toMediaType())
            )
            .baseUrl(Constant.BASE_URL)
            .build()
            .create(ApiInterface::class.java)
    }

    @Provides
    @Singleton
    fun provideHomeRepository(apiInterface: ApiInterface): HomeRepository {
        return HomeRepositoryImpl(apiInterface)
    }
}