package com.example.nytimesmostpopulararticles.ui.nytimesarticles

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.nytimesmostpopulararticles.R
import com.example.nytimesmostpopulararticles.databinding.ActivityMainBinding
import com.example.nytimesmostpopulararticles.ui.BaseActivity
import com.example.nytimesmostpopulararticles.utils.viewModelProvider
import javax.inject.Inject

class NyTimesArticlesMainActivity : BaseActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var articlesViewModel: NyTimesArticlesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        articlesViewModel = viewModelProvider(viewModelFactory)

        DataBindingUtil.setContentView<ActivityMainBinding>(
            this,
            R.layout.activity_main
        ).apply {
            viewModel = articlesViewModel
            lifecycleOwner = this@NyTimesArticlesMainActivity
        }

      /*  articlesViewModel.myArticles.observe(this, Observer { list ->
            rvList.adapter = ArticlesAdapter().apply {
                submitList(list.toMutableList())
            }
        })*/

    }

}