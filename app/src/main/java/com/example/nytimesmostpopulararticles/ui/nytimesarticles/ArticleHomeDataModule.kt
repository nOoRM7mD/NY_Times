package com.example.nytimesmostpopulararticles.ui.nytimesarticles

import com.example.nytimesmostpopulararticles.BuildConfig
import com.example.nytimesmostpopulararticles.api.ArticlesApiSpec
import com.example.nytimesmostpopulararticles.api.RetrofitArticlesApi
import com.example.nytimesmostpopulararticles.api.createService
import com.example.nytimesmostpopulararticles.data.repo.ArticlesApi
import com.example.nytimesmostpopulararticles.data.repo.ArticlesRepositoryImp
import com.example.nytimesmostpopulararticles.domain.ArticleRepository
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient

@Module
class ArticleHomeDataModule {

    @Provides
    fun provideArticles(api: ArticlesApi): ArticleRepository {
        return ArticlesRepositoryImp(api)
    }

    @Provides
    fun provideRetrofitArticlesApi(
        okHttpClient: OkHttpClient,
        gson: Gson
    ):
            ArticlesApiSpec {
        return createService(
            BuildConfig.BASE_URL,
            okHttpClient.newBuilder().addInterceptor { chain ->
                val request = chain.request()
                    .newBuilder()
                    .header("Accept", "application/json")
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .build()
                chain.proceed(request)
            }.build(), gson
        )
    }

    @Provides
    fun provideArticlesApi(apiSpec: ArticlesApiSpec): ArticlesApi {
        return RetrofitArticlesApi(apiSpec)
    }
}