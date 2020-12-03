package com.example.nytimesmostpopulararticles.ui

import android.content.Context
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {

    override fun onAttach(context: Context) {
        (activity as BaseActivity).androidInjector.inject(this)
        super.onAttach(context)
    }

}