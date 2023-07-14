package com.nlv22.fitnesstimetable.domain.entity

data class TrainingInfo(
    var lessons: List<Lesson>,
    val option: Option,
    val tabs: List<Tab>,
    val trainers: List<Trainer>
)
