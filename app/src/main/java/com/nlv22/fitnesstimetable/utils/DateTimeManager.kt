package com.nlv22.fitnesstimetable.utils

import java.text.SimpleDateFormat
import java.util.*

object DateTimeManager {

    /** Возвращает Date из формата "yyyy-MM-dd"  */
    fun getDate(dateString: String): Date = formatDate(PATTERN_TYPE_1, dateString)

    /** Возвращает Date из формата "HH:mm"  */
    fun getTime(dateString: String): Date = formatDate(PATTERN_TYPE_3, dateString)

    /** Преобразование даты из формата "yyyy-MM-dd" в формат "EEEE, dd MMMM"  */
    fun mapperStringDateToString(dateString: String): String =
        SimpleDateFormat(PATTERN_TYPE_2).format(getDate(dateString))

    private fun formatDate(pattern: String, dateString: String) =
        SimpleDateFormat(pattern).parse(dateString)


    private const val PATTERN_TYPE_1 = "yyyy-MM-dd"
    private const val PATTERN_TYPE_2 = "EEEE, dd MMMM"
    private const val PATTERN_TYPE_3 = "HH:mm"

}
