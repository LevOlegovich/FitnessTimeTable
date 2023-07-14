package com.nlv22.fitnesstimetable.utils

/** Используется как тип данных в LiveData и для отслеживания статуса загрузки **/
sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T?) : Resource<T>(data = data)
    class Error<T>(message: String?) : Resource<T>(message = message)
    class Loading<T> : Resource<T>()
}


