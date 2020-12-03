package com.example.nytimesmostpopulararticles.data.repo

import androidx.lifecycle.LiveData
import com.example.nytimesmostpopulararticles.result.Result
import com.example.nytimesmostpopulararticles.data.ApiResponse
import com.example.nytimesmostpopulararticles.data.NetworkBoundResource
import com.example.nytimesmostpopulararticles.domain.ArticleRepository
import com.example.nytimesmostpopulararticles.models.MostPopularArticlesModel
import javax.inject.Inject

class ArticlesRepositoryImp @Inject constructor(private val api: ArticlesApi) :
    ArticleRepository {

    override fun getMostPopularArticles(
        period: Int,
        apiKey: String
    ): LiveData<Result<MostPopularArticlesModel>> {
        return object : NetworkBoundResource<MostPopularArticlesModel>() {
            override fun createCall(): LiveData<ApiResponse<MostPopularArticlesModel>> {
                return api.getMostPopularArticles(period, apiKey)
            }

        }.asLiveData()
    }
}