package com.nlv22.fitnesstimetable.utils

import java.text.SimpleDateFormat
import java.util.*

//DateUtils
object DateTimeManager {

    /** Возвращает дату в формате "yyyy-MM-dd"  */
    fun getDate(dateString: String): Date = formatDate(PATTERN_TYPE_1, dateString)

    fun getTime(dateString: String): Date = formatDate(PATTERN_TYPE_3, dateString)

    fun mapperStringDateToString(dateString: String): String =
        SimpleDateFormat(PATTERN_TYPE_2).format(getDate(dateString))

    private fun formatDate(pattern: String, dateString: String) = SimpleDateFormat(pattern).parse(dateString)


    private const val PATTERN_TYPE_1 = "yyyy-MM-dd"
    private const val PATTERN_TYPE_2 = "EEEE, dd MMMM"
    private const val PATTERN_TYPE_3 = "HH:mm"

}
