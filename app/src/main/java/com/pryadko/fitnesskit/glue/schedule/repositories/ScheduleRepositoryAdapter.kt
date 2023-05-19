package com.pryadko.fitnesskit.glue.schedule.repositories

import com.pryadko.fintesskit.data.schedule.ScheduleDataRepository
import com.pryadko.fitnesskit.features.schedule.domain.ScheduleRepository
import com.pryadko.fitnesskit.features.schedule.domain.entities.Lesson
import com.pryadko.fitnesskit.glue.schedule.mappers.ScheduleRepositoryAdapterMapper
import javax.inject.Inject

class ScheduleRepositoryAdapter @Inject constructor(
    private val dataRepository: ScheduleDataRepository,
    private val mapper: ScheduleRepositoryAdapterMapper
) : ScheduleRepository {

    override fun getLessonsList(
        onSuccess: (List<Lesson>) -> Unit, onError: (error: String) -> Unit
    ) {
        dataRepository.getLessonsList({ lessonDataEntityList ->
            onSuccess.invoke(
                mapper.mapLessonDataEntityListToLessonList(lessonDataEntityList)
            )
        }, onError)
    }
}