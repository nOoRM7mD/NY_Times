package com.example.nytimesmostpopulararticles.di

import com.example.nytimesmostpopulararticles.di.scope.ActivityScoped
import com.example.nytimesmostpopulararticles.ui.home.ArticlesHomeModule
import com.example.nytimesmostpopulararticles.ui.home.NyTimesArticlesMainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = [ArticlesHomeModule::class])
    internal abstract fun nyTimesArticlesMainActivity(): NyTimesArticlesMainActivity

}