package com.example.nytimesmostpopulararticles.ui.nytimesarticles

import androidx.lifecycle.ViewModel
import com.example.nytimesmostpopulararticles.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class ArticlesHomeModule{
    @Binds
    @IntoMap
    @ViewModelKey(NyTimesArticlesViewModel::class)
    internal abstract fun bindNyTimesArticlesViewModel(viewModel: NyTimesArticlesViewModel): ViewModel

}