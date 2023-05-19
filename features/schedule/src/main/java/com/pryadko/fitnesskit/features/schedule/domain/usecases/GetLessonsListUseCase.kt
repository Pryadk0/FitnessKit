package com.pryadko.fitnesskit.features.schedule.domain.usecases

import com.pryadko.fitnesskit.features.schedule.domain.ScheduleRepository
import com.pryadko.fitnesskit.features.schedule.domain.entities.Lesson
import javax.inject.Inject

class GetLessonsListUseCase @Inject constructor(
    private val repository: ScheduleRepository
) {

    fun getLessonsList(onSuccess: (List<Lesson>) -> Unit, onError: ((error: String) -> Unit)) =
        repository.getLessonsList(onSuccess, onError)

}