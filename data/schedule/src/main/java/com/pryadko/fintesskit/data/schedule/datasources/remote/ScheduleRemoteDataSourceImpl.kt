package com.pryadko.fintesskit.data.schedule.datasources.remote

import android.util.Log
import com.pryadko.fintesskit.data.schedule.datasources.ScheduleRemoteDataSource
import com.pryadko.fintesskit.data.schedule.entities.LessonDataEntity
import com.pryadko.fitnesskit.data.network.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

private const val TAG = "API request"

class ScheduleRemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService,
    private val mapper: ScheduleRemoteDataSourceMapper
) : ScheduleRemoteDataSource {

    private val compositeDisposable = CompositeDisposable()

    override fun getLessonsList(onSuccess: (List<LessonDataEntity>) -> Unit, onError: ((error: String) -> Unit)) {
        compositeDisposable.add(
            apiService.getScheduleInfo()
                .map {
                    mapper.mapScheduleResponseDtoToLessonDataEntityList(it)
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    onSuccess(it)
                }, {
                    Log.i(TAG, "API getScheduleInfo request error: ${it.message}")
                    onError("Check the internet connection")
                })
        )
    }

    protected fun finalize() {
        if (!compositeDisposable.isDisposed)
            compositeDisposable.dispose()
    }
}