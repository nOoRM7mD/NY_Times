package com.example.nytimesmostpopulararticles.domain

import androidx.lifecycle.LiveData
import com.example.nytimesmostpopulararticles.models.MostPopularArticlesModel
import com.example.nytimesmostpopulararticles.result.Result

interface ArticleRepository {
    fun getMostPopularArticles(period: Int, apiKey: String): LiveData<Result<MostPopularArticlesModel>>
}