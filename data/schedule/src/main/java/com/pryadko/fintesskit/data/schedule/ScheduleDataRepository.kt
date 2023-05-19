package com.pryadko.fintesskit.data.schedule

import com.pryadko.fintesskit.data.schedule.entities.LessonDataEntity

interface ScheduleDataRepository {

    fun getLessonsList(onSuccess: (List<LessonDataEntity>) -> Unit, onError: ((error: String) -> Unit))

}