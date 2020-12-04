package com.example.nytimesmostpopulararticles.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.*
import com.example.nytimesmostpopulararticles.result.Result
import com.example.nytimesmostpopulararticles.result.Event


/**
 * For Actvities, allows declarations like
 * ```
 * val myViewModel = viewModelProvider(myViewModelFactory)
 * ```
 */
inline fun <reified VM : ViewModel> FragmentActivity.viewModelProvider(
    provider: ViewModelProvider.Factory
) =
    ViewModelProviders.of(this, provider).get(VM::class.java)

/**
 * For Fragments, allows declarations like
 * ```
 * val myViewModel = viewModelProvider(myViewModelFactory)
 * ```
 */
inline fun <reified VM : ViewModel> Fragment.viewModelProvider(
    provider: ViewModelProvider.Factory
) =
    ViewModelProviders.of(this, provider).get(VM::class.java)

/** Uses `Transformations.map` on a LiveData */
fun <X, Y> LiveData<X>.map(body: (X) -> Y): LiveData<Y> {
    return Transformations.map(this, body)
}

fun <T> MediatorLiveData<Event<String>>.observeErrorFrom(source: LiveData<Result<T>>) {
    this.addSource(source) {
        if (it is Result.Error) {
            this.postValue(Event(it.errorMessage))
        }
    }
}

fun <T> observeLoadingFrom(source: LiveData<Result<T>>): LiveData<Boolean> {
    return source.map { it is Result.Loading }
}

fun <T, E> MediatorLiveData<E>.observeDataFrom(
    source: LiveData<Result<T>>,
    preProcessing: ((T) -> E)? = null
) {
    this.addSource(source) {
        if (it is Result.Success) {
            val result = if (preProcessing != null) preProcessing(it.data) else it.data
            this.postValue(result as E)
        }
    }
}

inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
    beginTransaction().func().commit()
}

