package com.pryadko.fitnesskit.data.network.di

import com.pryadko.fitnesskit.data.network.ApiFactory
import com.pryadko.fitnesskit.data.network.ApiService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
interface NetworkModule {

    companion object {

        @Singleton
        @Provides
        fun provideApiService(): ApiService = ApiFactory.getApiService()
    }
}