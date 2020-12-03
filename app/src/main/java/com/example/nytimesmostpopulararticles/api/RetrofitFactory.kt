package com.example.nytimesmostpopulararticles.api

import com.example.nytimesmostpopulararticles.api.utils.LiveDataCallAdapterFactory
import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

inline fun <reified T> createService(
    baseUrl: String,
    okHttpClient: OkHttpClient,
    gson: Gson
): T {

    return Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(LiveDataCallAdapterFactory())
        .client(okHttpClient)
        .build()
        .create(T::class.java)

}
