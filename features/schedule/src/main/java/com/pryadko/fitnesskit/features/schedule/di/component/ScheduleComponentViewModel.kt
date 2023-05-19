package com.pryadko.fitnesskit.features.schedule.di.component

import androidx.lifecycle.ViewModel

class ScheduleComponentViewModel : ViewModel() {

    private var scheduleComponent: ScheduleComponent? = null

    fun newScheduleComponent(dependencies: ScheduleComponentDependencies): ScheduleComponent {
        scheduleComponent =
            DaggerScheduleComponent.builder().componentDependencies(dependencies).build()
        scheduleComponent?.let { return it }
        throw RuntimeException("ScheduleComponent == null")
    }

    override fun onCleared() {
        scheduleComponent = null
        super.onCleared()
    }
}