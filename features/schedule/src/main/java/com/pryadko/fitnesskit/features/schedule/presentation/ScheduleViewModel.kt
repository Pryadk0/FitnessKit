package com.pryadko.fitnesskit.features.schedule.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pryadko.fitnesskit.features.schedule.domain.entities.Lesson
import com.pryadko.fitnesskit.features.schedule.domain.usecases.GetLessonsListUseCase
import javax.inject.Inject

class ScheduleViewModel @Inject constructor(
    private val getLessonsListUseCase: GetLessonsListUseCase
) : ViewModel() {

    private val _lessonsListLiveData: MutableLiveData<List<Lesson>> = MutableLiveData()
    val lessonsListLiveData: LiveData<List<Lesson>>
        get() = _lessonsListLiveData

    private val _lessonsListErrorLiveData: MutableLiveData<String> = MutableLiveData()
    val lessonsListErrorLiveData: LiveData<String>
        get() = _lessonsListErrorLiveData

    init {
        getLessonsListUseCase.getLessonsList({
            _lessonsListLiveData.value = it
        }, { _lessonsListErrorLiveData.value = it })
    }
}