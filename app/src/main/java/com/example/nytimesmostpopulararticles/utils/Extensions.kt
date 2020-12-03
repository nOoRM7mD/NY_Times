package com.example.nytimesmostpopulararticles.utils

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.*
import com.example.nytimesmostpopulararticles.result.Result
import com.example.nytimesmostpopulararticles.result.Event
import kotlin.reflect.KClass


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

fun <T : Activity> Activity.startActivity(cls: KClass<T>) {
    startActivity(Intent(this, cls.java))
}

fun Activity.makeStatusBarTransparent() {
    window.apply {
        addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        statusBarColor = Color.TRANSPARENT
    }
}

