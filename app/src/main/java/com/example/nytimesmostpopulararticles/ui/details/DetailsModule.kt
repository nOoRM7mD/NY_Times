package com.example.nytimesmostpopulararticles.ui.details

import androidx.lifecycle.ViewModel
import com.example.nytimesmostpopulararticles.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class DetailsModule {
    @Binds
    @IntoMap
    @ViewModelKey(DetailsViewModel::class)
    internal abstract fun bindDetailsViewModel(viewModel: DetailsViewModel): ViewModel

}