package com.example.nytimesmostpopulararticles.di

import android.content.Context
import android.net.ConnectivityManager
import com.example.nytimesmostpopulararticles.MainApplication
import dagger.Module
import dagger.Provides


@Module
class AppModule {
    @Provides
    fun provideContext(application: MainApplication): Context {
        return application.applicationContext
    }

    @Provides
    fun providesConnectivityManager(context: Context): ConnectivityManager =
        context.applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE)
                as ConnectivityManager

}