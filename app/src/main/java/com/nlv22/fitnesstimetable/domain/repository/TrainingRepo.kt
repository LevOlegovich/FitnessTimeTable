package com.nlv22.fitnesstimetable.domain.repository

import com.nlv22.fitnesstimetable.domain.entity.TrainingInfo

interface TrainingRepo {

    suspend fun loadTrainingInfo(): TrainingInfo

}