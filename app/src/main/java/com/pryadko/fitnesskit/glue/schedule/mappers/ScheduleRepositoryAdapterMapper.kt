package com.pryadko.fitnesskit.glue.schedule.mappers

import com.pryadko.fintesskit.data.schedule.entities.LessonDataEntity
import com.pryadko.fitnesskit.features.schedule.domain.entities.Lesson
import javax.inject.Inject

class ScheduleRepositoryAdapterMapper @Inject constructor() {

    fun mapLessonDataEntityListToLessonList(lessonDataEntityList: List<LessonDataEntity>): List<Lesson> =
        lessonDataEntityList.map { mapLessonDataEntityToLesson(it) }

    private fun mapLessonDataEntityToLesson(lessonDataEntity: LessonDataEntity): Lesson =
        Lesson(
            lessonDataEntity.name,
            lessonDataEntity.place,
            lessonDataEntity.startTime,
            lessonDataEntity.endTime,
            lessonDataEntity.date,
            lessonDataEntity.color,
            lessonDataEntity.trainerFullName
        )

}