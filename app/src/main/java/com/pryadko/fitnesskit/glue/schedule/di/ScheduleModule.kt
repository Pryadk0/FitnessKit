package com.pryadko.fitnesskit.glue.schedule.di

import com.pryadko.fintesskit.data.schedule.ScheduleDataRepository
import com.pryadko.fintesskit.data.schedule.ScheduleDataRepositoryImpl
import com.pryadko.fintesskit.data.schedule.datasources.ScheduleRemoteDataSource
import com.pryadko.fintesskit.data.schedule.datasources.remote.ScheduleRemoteDataSourceImpl
import com.pryadko.fitnesskit.features.schedule.ScheduleRouter
import com.pryadko.fitnesskit.features.schedule.domain.ScheduleRepository
import com.pryadko.fitnesskit.glue.schedule.ScheduleRouterImpl
import com.pryadko.fitnesskit.glue.schedule.repositories.ScheduleRepositoryAdapter
import dagger.Binds
import dagger.Module

@Module
interface ScheduleModule {

    @Binds
    fun bindScheduleRouter(impl: ScheduleRouterImpl): ScheduleRouter

    @Binds
    fun bindScheduleRepository(impl: ScheduleRepositoryAdapter): ScheduleRepository

    @Binds
    fun bindScheduleDataRepository(impl: ScheduleDataRepositoryImpl): ScheduleDataRepository

    @Binds
    fun bindScheduleRemoteDataSource(impl: ScheduleRemoteDataSourceImpl): ScheduleRemoteDataSource
}