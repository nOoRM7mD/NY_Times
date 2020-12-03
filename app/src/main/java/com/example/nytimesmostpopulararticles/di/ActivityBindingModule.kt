package com.example.nytimesmostpopulararticles.di

import com.example.nytimesmostpopulararticles.di.scope.ActivityScoped
import com.example.nytimesmostpopulararticles.ui.nytimesarticles.ArticleHomeDataModule
import com.example.nytimesmostpopulararticles.ui.nytimesarticles.ArticlesHomeModule
import com.example.nytimesmostpopulararticles.ui.nytimesarticles.NyTimesArticlesMainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = [ArticlesHomeModule::class, ArticleHomeDataModule::class])
    internal abstract fun nyTimesArticlesMainActivity(): NyTimesArticlesMainActivity

}