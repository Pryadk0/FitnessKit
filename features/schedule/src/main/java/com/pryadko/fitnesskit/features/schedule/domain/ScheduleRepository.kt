package com.pryadko.fitnesskit.features.schedule.domain

import com.pryadko.fitnesskit.features.schedule.domain.entities.Lesson

interface ScheduleRepository {

    fun getLessonsList(onSuccess: (List<Lesson>) -> Unit, onError: ((error: String) -> Unit))

}