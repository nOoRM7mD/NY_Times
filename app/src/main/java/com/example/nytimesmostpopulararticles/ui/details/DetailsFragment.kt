package com.example.nytimesmostpopulararticles.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.nytimesmostpopulararticles.databinding.FragmentDetailsBinding
import com.example.nytimesmostpopulararticles.models.Article
import com.example.nytimesmostpopulararticles.ui.BaseFragment
import com.example.nytimesmostpopulararticles.utils.viewModelProvider
import javax.inject.Inject

const val ARTICLE_DETAIL = "article details"

class DetailsFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var detailsViewModel: DetailsViewModel
    private lateinit var binding: FragmentDetailsBinding
    private lateinit var mArticle: Article

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            mArticle = it.get(ARTICLE_DETAIL) as Article
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        detailsViewModel = viewModelProvider(viewModelFactory)

        binding = FragmentDetailsBinding.inflate(inflater, container, false).apply {
            viewModel = detailsViewModel
            article = mArticle
            lifecycleOwner = viewLifecycleOwner
        }

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(article: Article) =
            DetailsFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARTICLE_DETAIL, article)
                }
            }
    }
}