package com.nlv22.fitnesstimetable.data.network.mapper

import com.nlv22.fitnesstimetable.data.network.model.LessonDto
import com.nlv22.fitnesstimetable.data.network.model.OptionDto
import com.nlv22.fitnesstimetable.data.network.model.TabDto
import com.nlv22.fitnesstimetable.data.network.model.TrainerDto
import com.nlv22.fitnesstimetable.domain.entity.Lesson
import com.nlv22.fitnesstimetable.domain.entity.Option
import com.nlv22.fitnesstimetable.domain.entity.Tab
import com.nlv22.fitnesstimetable.domain.entity.Trainer


fun LessonDto.toDomain() = Lesson(
    appointment_id = appointment_id,
    available_slots = available_slots,
    client_recorded = client_recorded,
    coach_id = coach_id,
    color = color,
    commercial = commercial,
    date = date,
    description = description,
    endTime = endTime,
    is_cancelled = is_cancelled,
    name = name,
    place = place,
    service_id = service_id,
    startTime = startTime,
    tab = tab,
    tab_id = tab_id
)

fun TabDto.toDomain() = Tab(
    id = id,
    name = name
)

fun TrainerDto.toDomain() = Trainer(
    description = description,
    full_name = full_name,
    id = id,
    image_url = image_url,
    image_url_medium = image_url_medium,
    image_url_small = image_url_small,
    last_name = last_name,
    name = name,
    position = position
)

fun OptionDto.toDomain() = Option(
    club_name = club_name,
    link_android = link_android,
    primary_color = primary_color,
    link_ios = link_ios,
    secondary_color = secondary_color
)

