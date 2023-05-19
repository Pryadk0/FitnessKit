package com.pryadko.fitnesskit.data.network.entities.schedule

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


data class RawLessonDto(
    @SerializedName("name")
    @Expose
    val name: String,

    @SerializedName("place")
    @Expose
    val place: String,

    @SerializedName("coach_id")
    @Expose
    val trainerId: String,

    @SerializedName("startTime")
    @Expose
    val startTime: String,

    @SerializedName("endTime")
    @Expose
    val endTime: String,

    @SerializedName("date")
    @Expose
    val date: String,

    @SerializedName("color")
    @Expose
    val color: String,
)