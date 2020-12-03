package com.example.nytimesmostpopulararticles.data

import androidx.annotation.MainThread
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.example.nytimesmostpopulararticles.result.Result

/**
 * A generic class that can provide a resource backed by both the sqlite database and the network.
 *
 *
 * You can read more about it in the [Architecture
 * Guide](https://developer.android.com/arch).
 * @param <ResultType>
 * @param <RequestType>
</RequestType></ResultType> */
abstract class NetworkBoundResource<ResultType>
@MainThread constructor() {

    private val result = MediatorLiveData<Result<ResultType>>()

    init {
        result.value = Result.Loading(null)
        fetchFromNetwork()
    }

    @MainThread
    private fun setValue(newValue: Result<ResultType>) {
        if (result.value != newValue) {
            result.value = newValue
        }
    }

    private fun fetchFromNetwork() {
        val apiResponse = createCall()
        result.addSource(apiResponse) { response ->
            result.removeSource(apiResponse)
            when (response) {
                is ApiSuccessResponse -> {
                    setValue(Result.Success(processResponse(response)))
                }
                is ApiEmptyResponse -> {
                    setValue(Result.Error("empty"))
                }
                is ApiErrorResponse -> {
                    setValue(Result.Error(response.errorMessage))
                }
            }
        }
    }

    fun asLiveData() = result as LiveData<Result<ResultType>>

    @WorkerThread
    protected open fun processResponse(response: ApiSuccessResponse<ResultType>) =
        response.body!!

    @MainThread
    protected abstract fun createCall(): LiveData<ApiResponse<ResultType>>
}
