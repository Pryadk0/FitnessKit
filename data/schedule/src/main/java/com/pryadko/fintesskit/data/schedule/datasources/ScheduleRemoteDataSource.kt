package com.pryadko.fintesskit.data.schedule.datasources

import com.pryadko.fintesskit.data.schedule.entities.LessonDataEntity

interface ScheduleRemoteDataSource {

    fun getLessonsList(onSuccess: (List<LessonDataEntity>) -> Unit, onError: ((error: String) -> Unit))

}