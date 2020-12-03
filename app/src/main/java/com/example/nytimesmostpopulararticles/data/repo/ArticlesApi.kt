package com.example.nytimesmostpopulararticles.data.repo

import androidx.lifecycle.LiveData
import com.example.nytimesmostpopulararticles.data.ApiResponse
import com.example.nytimesmostpopulararticles.models.MostPopularArticlesModel

interface ArticlesApi {
    fun getMostPopularArticles(period: Int, apiKey: String): LiveData<ApiResponse<MostPopularArticlesModel>>

}