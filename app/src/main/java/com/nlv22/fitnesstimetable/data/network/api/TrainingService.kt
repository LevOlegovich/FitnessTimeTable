package com.nlv22.fitnesstimetable.data.network.api

import com.nlv22.fitnesstimetable.data.network.model.ResponseTrainingInfo
import retrofit2.http.GET
import retrofit2.http.Query

interface TrainingService {

    @GET("/schedule/get_v3/")
    suspend fun getTrainingInfo(@Query("club_id") query: Int = 2): ResponseTrainingInfo

}