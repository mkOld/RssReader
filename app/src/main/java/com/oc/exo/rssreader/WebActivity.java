package com.oc.exo.rssreader;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebActivity extends AppCompatActivity {

    WebView webView;
    String title;
    String htmlContent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        webView = (WebView)findViewById(R.id.wvRSS);

        webView.getSettings().setJavaScriptEnabled(true); // active javascript

        // ouvre tout sur la même webview
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(request.toString());
                return false;
            }
        });

        title = getIntent().getStringExtra("TITLE");
        htmlContent = getIntent().getStringExtra("HTML_CONTENT");

        setTitle(title);
        webView.loadData(htmlContent, "text/html; charset=UTF-8", null);

    }
}
