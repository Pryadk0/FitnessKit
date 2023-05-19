package com.pryadko.fitnesskit.glue

import android.app.Application
import com.pryadko.fitnesskit.di.ApplicationComponent
import com.pryadko.fitnesskit.features.schedule.di.component.ScheduleComponentDependencies
import com.pryadko.fitnesskit.features.schedule.di.component.ScheduleComponentDependenciesProvider
import com.pryadko.fitnesskit.di.DaggerApplicationComponent

class FitnessKitApplication : Application(),
    ScheduleComponentDependenciesProvider {

    private lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.factory().create(this)
    }

    override fun getScheduleComponentDependencies(): ScheduleComponentDependencies =
        applicationComponent
}