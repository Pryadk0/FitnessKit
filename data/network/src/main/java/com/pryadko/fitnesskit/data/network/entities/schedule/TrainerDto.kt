package com.pryadko.fitnesskit.data.network.entities.schedule

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




data class TrainerDto (
    @SerializedName("id")
    @Expose
    val id: String,

    @SerializedName("full_name")
    @Expose
    val fullName: String,
)