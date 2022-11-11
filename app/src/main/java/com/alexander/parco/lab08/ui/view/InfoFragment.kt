package com.alexander.parco.lab08.ui.view

import android.os.Bundle
import android.view.View
import android.webkit.WebView
import androidx.fragment.app.Fragment
import com.alexander.parco.lab08.databinding.FragmentInfoBinding

class InfoFragment: BaseFragment<FragmentInfoBinding>(FragmentInfoBinding::inflate){
    private lateinit var webView: WebView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val url = "https://pokemongolive.com/"
        webView = binding.wvInfoFrament

        webView.settings.javaScriptEnabled = true

        webView.loadUrl(url)
    }
}