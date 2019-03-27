package nl.hva.madlevel3.features.presentation.webview

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.fragment_web_view.*
import nl.hva.madlevel3.core.platform.BaseFragment
import nl.hva.madlevel3.R

class WebViewFragment : BaseFragment() {

    override fun layoutId() = R.layout.fragment_web_view

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val url = arguments?.let {
            WebViewFragmentArgs.fromBundle(it).url
        }
        webView.settings.javaScriptEnabled = true
        webView.loadUrl(url)
    }

}