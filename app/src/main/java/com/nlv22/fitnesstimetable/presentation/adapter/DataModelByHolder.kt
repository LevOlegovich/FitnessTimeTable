package com.nlv22.fitnesstimetable.presentation.adapter

import com.nlv22.fitnesstimetable.domain.entity.Lesson
import com.nlv22.fitnesstimetable.domain.entity.Trainer

/** Вспомогательный класс для реализации RecyclerView (multiple view types) **/
sealed class DataModelByHolder {
    data class HeaderDate(
        var title: String = ""
    ) : DataModelByHolder()

    data class ItemTraining(
        var lesson: Lesson? = null,
        var trainer: Trainer? = null
    ) : DataModelByHolder()

}