package com.pryadko.fitnesskit.features.schedule.di.component

import com.pryadko.fitnesskit.features.schedule.ScheduleRouter
import com.pryadko.fitnesskit.features.schedule.domain.ScheduleRepository

interface ScheduleComponentDependencies {

    fun getScheduleRouter(): ScheduleRouter

    fun getScheduleRepository(): ScheduleRepository
}