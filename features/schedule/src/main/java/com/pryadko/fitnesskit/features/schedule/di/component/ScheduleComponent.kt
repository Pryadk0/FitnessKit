package com.pryadko.fitnesskit.features.schedule.di.component

import com.pryadko.fitnesskit.features.schedule.di.modules.ScheduleViewModelModule
import com.pryadko.fitnesskit.features.schedule.di.scopes.ScheduleFeatureScope
import com.pryadko.fitnesskit.features.schedule.presentation.ScheduleFragment
import dagger.Component

@ScheduleFeatureScope
@Component(
    modules = [ScheduleViewModelModule::class],
    dependencies = [ScheduleComponentDependencies::class]
)
interface ScheduleComponent {

    fun injectScheduleFragment(scheduleFragment: ScheduleFragment)

    @Component.Builder
    interface Builder {

        fun componentDependencies(dependencies: ScheduleComponentDependencies): Builder

        fun build(): ScheduleComponent

    }
}