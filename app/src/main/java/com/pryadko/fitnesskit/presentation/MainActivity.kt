package com.pryadko.fitnesskit.presentation

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.pryadko.fintesskit.data.schedule.datasources.remote.ScheduleRemoteDataSourceImpl
import com.pryadko.fintesskit.data.schedule.datasources.remote.ScheduleRemoteDataSourceMapper
import com.pryadko.fitnesskit.R
import com.pryadko.fitnesskit.data.network.ApiFactory
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.statusBarColor = getColor(com.pryadko.fintesskit.core.theme.R.color.black)


/*        //Test:

        val testRemoteDSImpl = ScheduleRemoteDataSourceImpl(
            ApiFactory.getApiService(), ScheduleRemoteDataSourceMapper()
        )
        testRemoteDSImpl.getLessonsList ({
            Log.i(
                "TAG", "Lesson = ${it[0].name}, " +
                        "trainer = ${it[0].trainerFullName}, " +
                        "trainer id = ${it[0].trainerId}, " +
                        "color = ${it[0].color}, " +
                        "date = ${it[0].date}," +
                        "startTime = ${it[0].startTime}, " +
                        "endTime = ${it[0].endTime} ," +
                        "place = ${it[0].place}, " +
                        "LIST SIZE = ${it.size}"
            )

            _______________________________

            it.forEach {lesson ->
                Log.i("TAG", " date = ${lesson.date.trim()}, startTime = ${lesson.startTime.trim()}, endTime = ${lesson.endTime.trim()}")
            }



        }, {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        })



        //End of the test

 */
    }


}