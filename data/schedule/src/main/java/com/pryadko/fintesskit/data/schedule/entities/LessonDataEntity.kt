package com.pryadko.fintesskit.data.schedule.entities


data class LessonDataEntity(
    val name: String,
    val place: String,
    val startTime: String,
    val endTime: String,
    val date: String,
    val color: String,
    val trainerFullName: String,
    val trainerId: String
)