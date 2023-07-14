package com.nlv22.fitnesstimetable.domain.usecase

import com.nlv22.fitnesstimetable.domain.entity.TrainingInfo
import com.nlv22.fitnesstimetable.domain.repository.TrainingRepo
import com.nlv22.fitnesstimetable.utils.DateTimeManager
import javax.inject.Inject

class LoadTrainingInfoFromServerUseCase @Inject constructor(private val repo: TrainingRepo) {

    suspend operator fun invoke() = sortByDateAndTimeTrainingInfo(repo.loadTrainingInfo())

    /** сортировка загруженных данных по дате и времени **/
    private fun sortByDateAndTimeTrainingInfo(data: TrainingInfo): TrainingInfo {
        val lessons = data.lessons

        data.lessons = lessons.sortedWith(
            compareBy({
                DateTimeManager.getDate(it.date)
            }, {
                DateTimeManager.getTime(it.startTime)
            })
        )
        return data
    }
}
