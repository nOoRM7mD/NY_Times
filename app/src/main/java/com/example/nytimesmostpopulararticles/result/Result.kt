package com.example.nytimesmostpopulararticles.result

import com.example.nytimesmostpopulararticles.result.Result.Success

/**
 * A generic class that holds a value with its loading status.
 * @param <T>
 */
sealed class Result<out R> {

    data class Success<out T>(val data: T) : Result<T>()
    data class Error<out T>(val errorMessage: String, val data: T? = null) : Result<T>()
    data class Loading<out T>(val data: T? = null) : Result<T>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error<*> -> {
                "Error[errorMsg=$errorMessage${if (data != null) "data=$data" else ""}]"
            }
            is Loading<*> -> "Loading${if (data != null) "data=$data" else ""}"
        }
    }
}

/**
 * `true` if [Result] is of type [Success] & holds non-null [Success.data].
 */
val Result<*>.succeeded
    get() = this is Success && data != null

fun <T> Result<T>.successOr(fallback: T): T {
    return (this as? Success<T>)?.data ?: fallback
}

fun <T, E> Result<T>.map(body: (T?) -> (E?)): Result<E> {
    return when (this) {
        is Result.Success<T> -> Result.Success(body(this.data)!!)
        is Result.Error<T> -> Result.Error(this.errorMessage, body(this.data))
        is Result.Loading<T> -> Result.Loading(body(this.data))
    }
}
