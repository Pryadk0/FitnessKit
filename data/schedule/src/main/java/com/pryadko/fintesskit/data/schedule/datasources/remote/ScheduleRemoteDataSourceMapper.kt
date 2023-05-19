package com.pryadko.fintesskit.data.schedule.datasources.remote

import com.pryadko.fintesskit.data.schedule.entities.LessonDataEntity
import com.pryadko.fitnesskit.data.network.entities.schedule.ScheduleResponseDto
import java.lang.StringBuilder
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import javax.inject.Inject

class ScheduleRemoteDataSourceMapper @Inject constructor() {

    fun mapScheduleResponseDtoToLessonDataEntityList(scheduleResponseDto: ScheduleResponseDto): List<LessonDataEntity> {
        val dateSortableList = mutableListOf<LessonDataSortableEntity>()
        for (i in 0 until scheduleResponseDto.rawLessons.size)
            for (j in 0 until scheduleResponseDto.trainers.size)
                if (scheduleResponseDto.rawLessons[i].trainerId == scheduleResponseDto.trainers[j].id)
                    dateSortableList.add(
                        LessonDataSortableEntity(
                            scheduleResponseDto.rawLessons[i].name.trim(),
                            scheduleResponseDto.rawLessons[i].place.trim(),
                            scheduleResponseDto.rawLessons[i].startTime.trim(),
                            scheduleResponseDto.rawLessons[i].endTime.trim(),
                            mapIncomeStringDateToDateTime(
                                scheduleResponseDto.rawLessons[i].date.trim(),
                                scheduleResponseDto.rawLessons[i].startTime.trim()
                            ),
                            scheduleResponseDto.rawLessons[i].color.trim(),
                            scheduleResponseDto.trainers[j].fullName.trim(),
                            scheduleResponseDto.trainers[j].id.trim()
                        )
                    )
        dateSortableList.sortBy { it.dateTime }
        val sortedDataEntityList = mapDateSortableListToLessonDataEntityList(dateSortableList)
        return mapSortedDataEntityListToResultDataEntityList(sortedDataEntityList)
    }

    private fun mapIncomeStringDateToDateTime(
        incomeStringDate: String,
        incomeStringTime: String
    ): Date {
        val dateTimeString = StringBuilder(incomeStringDate)
            .append(" ")
            .append(incomeStringTime)
            .toString()
        return SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault())
            .parse(dateTimeString) as Date
    }

    private fun mapDateSortableListToLessonDataEntityList(dateSortableList: List<LessonDataSortableEntity>): List<LessonDataEntity> =
        List(dateSortableList.size) {
            LessonDataEntity(
                dateSortableList[it].name,
                dateSortableList[it].place,
                dateSortableList[it].startTime,
                dateSortableList[it].endTime,
                mapDateTimeToDateString(dateSortableList[it].dateTime),
                dateSortableList[it].color,
                dateSortableList[it].trainerFullName,
                dateSortableList[it].trainerId
            )
        }

    private fun mapDateTimeToDateString(dateTime: Date): String =
        SimpleDateFormat("EEEE, dd MMMM", Locale.getDefault())
            .format(dateTime)

    private fun mapSortedDataEntityListToResultDataEntityList(sortedDataEntityList: List<LessonDataEntity>): List<LessonDataEntity> {
        var currentDate = ""
        val result = mutableListOf<LessonDataEntity>()
        sortedDataEntityList.map {
            if (it.date != currentDate) {
                currentDate = it.date
                result.add(it)
            } else result.add(
                LessonDataEntity(
                    it.name,
                    it.place,
                    it.startTime,
                    it.endTime,
                    "",
                    it.color,
                    it.trainerFullName,
                    it.trainerId
                )
            )
        }
        return result
    }


    /***
     * The same class as LessonDataEntity, but 'date' property is Date typed
     */
    private inner class LessonDataSortableEntity(
        val name: String,
        val place: String,
        val startTime: String,
        val endTime: String,
        val dateTime: Date,
        val color: String,
        val trainerFullName: String,
        val trainerId: String
    )
}