package com.nlv22.fitnesstimetable.data.network.model

data class TrainerDto(
    val description: String,
    val full_name: String,
    val id: String,
    val image_url: String,
    val image_url_medium: String,
    val image_url_small: String,
    val last_name: String,
    val name: String,
    val position: String
)