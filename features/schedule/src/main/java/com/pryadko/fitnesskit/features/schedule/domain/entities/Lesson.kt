package com.pryadko.fitnesskit.features.schedule.domain.entities

data class Lesson (
    val name: String,
    val place: String,
    val startTime: String,
    val endTime: String,
    val date: String,
    val color: String,
    val trainerFullName: String
)