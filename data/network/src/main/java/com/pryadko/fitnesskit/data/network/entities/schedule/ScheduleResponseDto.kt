package com.pryadko.fitnesskit.data.network.entities.schedule

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ScheduleResponseDto (
    @SerializedName("trainers")
    @Expose
    val trainers: List<TrainerDto>,

    @SerializedName("lessons")
    @Expose
    val rawLessons: List<RawLessonDto>
)