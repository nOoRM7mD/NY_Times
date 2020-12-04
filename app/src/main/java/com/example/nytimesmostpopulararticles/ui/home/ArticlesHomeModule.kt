package com.example.nytimesmostpopulararticles.ui.home

import androidx.lifecycle.ViewModel
import com.example.nytimesmostpopulararticles.di.ViewModelKey
import com.example.nytimesmostpopulararticles.di.scope.FragmentScoped
import com.example.nytimesmostpopulararticles.ui.details.DetailsFragment
import com.example.nytimesmostpopulararticles.ui.details.DetailsModule
import com.example.nytimesmostpopulararticles.ui.nytimesarticles.ArticleHomeDataModule
import com.example.nytimesmostpopulararticles.ui.nytimesarticles.MostPopularArticlesFragment
import com.example.nytimesmostpopulararticles.ui.nytimesarticles.PopularArticlesModule
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
internal abstract class ArticlesHomeModule {

    @FragmentScoped
    @ContributesAndroidInjector(modules = [DetailsModule::class])
    internal abstract fun contributeDetailsFragment(): DetailsFragment

    @FragmentScoped
    @ContributesAndroidInjector(modules = [PopularArticlesModule::class, ArticleHomeDataModule::class])
    internal abstract fun contributeMostPopularArticlesFragment(): MostPopularArticlesFragment

    @Binds
    @IntoMap
    @ViewModelKey(ArticlesHomeViewModel::class)
    internal abstract fun bindArticlesHomeViewModel(viewModel: ArticlesHomeViewModel): ViewModel

}
