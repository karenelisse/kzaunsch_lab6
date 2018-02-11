package edu.asu.ser421.lab6;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebCityActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_city);

        WebView browser = (WebView)findViewById(R.id.webView2);
        browser.setWebViewClient(new WebViewClient(){
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return true;
            }
        });
        browser.setWebContentsDebuggingEnabled(true);
        // need this
        //browser.setWebChromeClient(new WebChromeClient(){});
        WebSettings webSettings = browser.getSettings();
        webSettings.setJavaScriptEnabled(false);
        webSettings.setAllowUniversalAccessFromFileURLs(false);
        webSettings.setDomStorageEnabled(false);
        browser.loadUrl(MainActivity.url);

    }
}


