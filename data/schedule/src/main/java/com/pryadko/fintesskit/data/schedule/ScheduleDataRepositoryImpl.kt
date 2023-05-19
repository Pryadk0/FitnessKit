package com.pryadko.fintesskit.data.schedule

import com.pryadko.fintesskit.data.schedule.datasources.ScheduleRemoteDataSource
import com.pryadko.fintesskit.data.schedule.entities.LessonDataEntity
import javax.inject.Inject
import kotlin.concurrent.thread


class ScheduleDataRepositoryImpl @Inject constructor(
    private val remoteDataSource: ScheduleRemoteDataSource
) : ScheduleDataRepository {

    override fun getLessonsList(
        onSuccess: (List<LessonDataEntity>) -> Unit,
        onError: ((error: String) -> Unit)
    ) {
        //thread {
            remoteDataSource.getLessonsList(onSuccess, onError)
        //}.start()

    }
}