package com.example.nytimesmostpopulararticles.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.nytimesmostpopulararticles.R
import com.example.nytimesmostpopulararticles.models.Article
import com.example.nytimesmostpopulararticles.ui.BaseActivity
import com.example.nytimesmostpopulararticles.ui.details.DetailsFragment
import com.example.nytimesmostpopulararticles.ui.nytimesarticles.MostPopularArticlesFragment
import com.example.nytimesmostpopulararticles.utils.inTransaction
import javax.inject.Inject

class NyTimesArticlesMainActivity : BaseActivity(),
    FragmentNavigatorListener {

    private val mostPopularArticlesFragment by lazy {
        MostPopularArticlesFragment.newInstance(
            this
        )
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        showFragment(mostPopularArticlesFragment)
    }

    override fun navigateToDetailsFragment(article: Article) {
        showFragment(DetailsFragment.newInstance(article))
    }

    private fun showFragment(cls: Fragment) {
        supportFragmentManager.inTransaction {
            replace(R.id.content, cls)
        }
    }
}

interface FragmentNavigatorListener {
    fun navigateToDetailsFragment(article: Article)
}