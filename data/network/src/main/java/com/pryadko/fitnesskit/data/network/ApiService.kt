package com.pryadko.fitnesskit.data.network


import com.pryadko.fitnesskit.data.network.entities.schedule.ScheduleResponseDto
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiService {

    @GET(ENDPOINT_SCHEDULE)
    fun getScheduleInfo(): Observable<ScheduleResponseDto>

    companion object{

        private const val ENDPOINT_SCHEDULE = "schedule/get_v3/?club_id=2"

    }

}