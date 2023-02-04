package com.nlv22.fitnesstimetable.data.network.model

data class ResponseTrainingInfo(
    val lessons: List<LessonDto>,
    val option: OptionDto,
    val tabs: List<TabDto>,
    val trainers: List<TrainerDto>
)