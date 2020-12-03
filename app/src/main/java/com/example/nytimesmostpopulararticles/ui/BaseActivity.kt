package com.example.nytimesmostpopulararticles.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.nytimesmostpopulararticles.utils.makeStatusBarTransparent
import dagger.android.DispatchingAndroidInjector
import javax.inject.Inject


abstract class BaseActivity : AppCompatActivity() {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        makeStatusBarTransparent()
    }
}