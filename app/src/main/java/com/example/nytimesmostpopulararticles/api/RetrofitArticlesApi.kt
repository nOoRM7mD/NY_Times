package com.example.nytimesmostpopulararticles.api

import androidx.lifecycle.LiveData
import com.example.nytimesmostpopulararticles.data.ApiResponse
import com.example.nytimesmostpopulararticles.data.repo.ArticlesApi
import com.example.nytimesmostpopulararticles.models.Article
import com.example.nytimesmostpopulararticles.models.MostPopularArticlesModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import javax.inject.Inject

interface ArticlesApiSpec {
    @GET("/svc/mostpopular/v2/viewed/{period}.json")
    fun getNews(@Path("period") period: Int, @Query("api-key") key : String): LiveData<ApiResponse<MostPopularArticlesModel>>

    @GET("/svc/mostpopular/v2/viewed/{period}.json")
    fun getNewsForTesting(@Path("period") period: Int, @Query("api-key") key : String): Call<Article>

}

class RetrofitArticlesApi @Inject constructor(private val apiSpec: ArticlesApiSpec) :
    ArticlesApi {

    override fun getMostPopularArticles(period: Int,apiKey: String): LiveData<ApiResponse<MostPopularArticlesModel>> {
        return apiSpec.getNews(period, apiKey)
    }
}