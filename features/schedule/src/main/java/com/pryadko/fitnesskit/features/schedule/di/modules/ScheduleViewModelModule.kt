package com.pryadko.fitnesskit.features.schedule.di.modules

import androidx.lifecycle.ViewModel
import com.pryadko.fintesskit.core.presentation.viewmodel.ViewModelKey
import com.pryadko.fitnesskit.features.schedule.presentation.ScheduleViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ScheduleViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ScheduleViewModel::class)
    fun bindScheduleViewModel(impl: ScheduleViewModel): ViewModel

}