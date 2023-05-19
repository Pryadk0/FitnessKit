package com.pryadko.fitnesskit.di

import android.content.Context
import com.pryadko.fitnesskit.data.network.di.NetworkModule
import com.pryadko.fitnesskit.features.schedule.ScheduleRouter
import com.pryadko.fitnesskit.features.schedule.di.component.ScheduleComponentDependencies
import com.pryadko.fitnesskit.features.schedule.domain.ScheduleRepository
import com.pryadko.fitnesskit.glue.schedule.di.ScheduleModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NetworkModule::class,
        ScheduleModule::class
    ]
)
interface ApplicationComponent : ScheduleComponentDependencies {

    //ScheduleComponentDependencies:
    override fun getScheduleRouter(): ScheduleRouter

    override fun getScheduleRepository(): ScheduleRepository

    @Component.Factory
    interface ApplicationComponentFactory {
        fun create(@BindsInstance context: Context): ApplicationComponent
    }
}