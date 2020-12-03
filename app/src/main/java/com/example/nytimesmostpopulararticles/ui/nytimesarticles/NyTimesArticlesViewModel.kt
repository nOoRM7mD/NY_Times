package com.example.nytimesmostpopulararticles.ui.nytimesarticles

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.example.nytimesmostpopulararticles.BuildConfig
import com.example.nytimesmostpopulararticles.domain.ArticlesUseCase
import com.example.nytimesmostpopulararticles.domain.Parameters
import com.example.nytimesmostpopulararticles.models.Article
import com.example.nytimesmostpopulararticles.result.Event
import com.example.nytimesmostpopulararticles.utils.observeDataFrom
import com.example.nytimesmostpopulararticles.utils.observeErrorFrom
import com.example.nytimesmostpopulararticles.utils.observeLoadingFrom
import javax.inject.Inject

class NyTimesArticlesViewModel @Inject constructor(private val useCase: ArticlesUseCase) : ViewModel() {

    var loading: LiveData<Boolean>

    private val _errorMessage = MediatorLiveData<Event<String>>()
    val errorMessage: LiveData<Event<String>>
        get() = _errorMessage

    private val _mostPopularArticles = MediatorLiveData<List<Article>>()
    val mostPopularArticles: LiveData<List<Article>>
        get() = _mostPopularArticles

    private val loadMostPopularArticles = useCase.observe()

    init {

        loading = observeLoadingFrom(loadMostPopularArticles)
        _errorMessage.observeErrorFrom(loadMostPopularArticles)

        _mostPopularArticles.observeDataFrom(loadMostPopularArticles){
            it.results!!
        }
        useCase.execute(Parameters(1 ,BuildConfig.API_KEY))
    }
}