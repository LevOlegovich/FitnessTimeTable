package com.nlv22.fitnesstimetable.data.repository

import com.nlv22.fitnesstimetable.data.network.api.TrainingService
import com.nlv22.fitnesstimetable.data.network.mapper.toDomain
import com.nlv22.fitnesstimetable.domain.entity.TrainingInfo
import com.nlv22.fitnesstimetable.domain.repository.TrainingRepo
import javax.inject.Inject

class TrainingRepoImpl @Inject constructor(
    private val trainingService: TrainingService,
) : TrainingRepo {

    override suspend fun loadTrainingInfo(): TrainingInfo {
        trainingService.getTrainingInfo().apply {
            val lessons = this.lessons.map { it.toDomain() }
            val option = this.option.toDomain()
            val tabs = this.tabs.map { it.toDomain() }
            val trainers = this.trainers.map { it.toDomain() }
            return TrainingInfo(
                lessons = lessons,
                option = option,
                tabs = tabs,
                trainers = trainers
            )
        }
    }
}
