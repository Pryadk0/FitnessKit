package com.pryadko.fintesskit.data.schedule.datasources.remote

import com.pryadko.fintesskit.data.schedule.entities.LessonDataEntity
import com.pryadko.fitnesskit.data.network.entities.schedule.ScheduleResponseDto
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
                            scheduleResponseDto.rawLessons[i].name,
                            scheduleResponseDto.rawLessons[i].place,
                            scheduleResponseDto.rawLessons[i].startTime,
                            scheduleResponseDto.rawLessons[i].endTime,
                            mapIncomeStringDateToDate(scheduleResponseDto.rawLessons[i].date),
                            scheduleResponseDto.rawLessons[i].color,
                            scheduleResponseDto.trainers[j].fullName,
                            scheduleResponseDto.trainers[j].id
                        )
                    )
        dateSortableList.sortBy {
            it.date
        }
        return mapDateSortableListToLessonDataEntityList(dateSortableList)
    }

    private fun mapIncomeStringDateToDate(incomeStringDate: String): Date =
        SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            .parse(incomeStringDate) as Date

    private fun mapIncomeDateToFormattedString(incomeDate: Date): String =
        SimpleDateFormat("EEEE, dd MMMM", Locale.getDefault()).format(incomeDate)

    private fun mapDateSortableListToLessonDataEntityList(dateSortableList: List<LessonDataSortableEntity>): List<LessonDataEntity> =
        List(dateSortableList.size) {
            LessonDataEntity(
                dateSortableList[it].name.trim(),
                dateSortableList[it].place.trim(),
                dateSortableList[it].startTime.trim(),
                dateSortableList[it].endTime.trim(),
                mapIncomeDateToFormattedString(dateSortableList[it].date),
                dateSortableList[it].color.trim(),
                dateSortableList[it].trainerFullName.trim(),
                dateSortableList[it].trainerId
            )
        }

    /***
     * The same class as LessonDataEntity, but 'date' property is Date typed
     */
    private inner class LessonDataSortableEntity(
        val name: String,
        val place: String,
        val startTime: String,
        val endTime: String,
        val date: Date,
        val color: String,
        val trainerFullName: String,
        val trainerId: String
    )
}