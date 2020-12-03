package com.example.nytimesmostpopulararticles.domain

import com.example.nytimesmostpopulararticles.models.MostPopularArticlesModel
import javax.inject.Inject
import com.example.nytimesmostpopulararticles.result.Result

class ArticlesUseCase @Inject constructor(
    private val repository: ArticleRepository
) : MediatorUseCase<Parameters, MostPopularArticlesModel>() {

    override fun execute(params: Parameters) {
        try {
            val observableMostPopularArticles =
                repository.getMostPopularArticles(params.period, params.apiKey)
            result.removeSource(observableMostPopularArticles)
            result.addSource(observableMostPopularArticles) {
                result.postValue(it)
            }
        } catch (e: Exception) {
            result.postValue(Result.Error(e.message ?: "unknown error"))
        }
    }

}

data class Parameters(val period: Int, val apiKey: String)