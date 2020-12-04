package com.example.nytimesmostpopulararticles.ui.nytimesarticles

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.nytimesmostpopulararticles.databinding.FragmentMostPopularArticlesBinding
import com.example.nytimesmostpopulararticles.ui.BaseFragment
import com.example.nytimesmostpopulararticles.ui.home.FragmentNavigatorListener
import com.example.nytimesmostpopulararticles.utils.viewModelProvider
import kotlinx.android.synthetic.main.fragment_most_popular_articles.*
import javax.inject.Inject

class MostPopularArticlesFragment : BaseFragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var articlesViewModel: NyTimesArticlesViewModel

    private lateinit var binding: FragmentMostPopularArticlesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        articlesViewModel = viewModelProvider(viewModelFactory)

        binding = FragmentMostPopularArticlesBinding.inflate(inflater, container, false).apply {
            viewModel = articlesViewModel
            lifecycleOwner = viewLifecycleOwner
        }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        articlesViewModel.mostPopularArticles.observe(this, Observer { list ->
            rvList.adapter =
                ArticlesAdapter { mListener.navigateToDetailsFragment(list[it]) }.apply {

                    submitList(list.toMutableList())
                }
        })

        articlesViewModel.errorMessage.observe(this, Observer {
            Toast.makeText(activity, it.peekContent(), Toast.LENGTH_SHORT).show()
        })
    }

    companion object {

        lateinit var mListener: FragmentNavigatorListener

        @JvmStatic
        fun newInstance(listener: FragmentNavigatorListener) =
            MostPopularArticlesFragment().apply {
                mListener = listener
            }
    }
}