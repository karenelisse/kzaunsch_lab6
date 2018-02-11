package edu.asu.ser421.lab6;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

public class WebActivity extends AppCompatActivity {
    private WebView browser;
    private Button goBackButton;

    //disables back button
    @Override
    public void onBackPressed() {
        // do nothing.
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        //creates and enables goBackButton
        goBackButton = (Button)findViewById(R.id.button7);
        goBackButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent webIntent = new Intent(WebActivity.this, MainActivity.class);
                startActivity(webIntent);
            }
        });

        // Get what was passed to us

        WebView browser = (WebView)findViewById(R.id.webView);
        browser.addJavascriptInterface(new WebAppInterface(this), "Android");
        browser.setWebContentsDebuggingEnabled(true);
        browser.saveState(savedInstanceState);
        // need this
        browser.setWebChromeClient(new WebChromeClient(){});
        browser.setWebViewClient(new WebViewClient());
        // enable JS
        WebSettings webSettings = browser.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowUniversalAccessFromFileURLs(true);
        webSettings.setDomStorageEnabled(true);
        if (savedInstanceState != null){
            browser.restoreState(savedInstanceState);
        }
        else {
            browser.loadUrl("file:///android_asset/www/AjaxWeather.html");
        }
        browser.addJavascriptInterface(new WebAppInterface(this), "Android");
    }
}

class WebAppInterface {
    private Context mContext;
    public String data;
    public static String saveData;

    WebAppInterface(Context c) {
        mContext = c;
    }

    @JavascriptInterface
    public String showCity1() {
        return ChangeActivity.city1;
    }
    @JavascriptInterface
    public String showCity2() {
        return ChangeActivity.city2;
    }
    @JavascriptInterface
    public String showCity3() {
        return ChangeActivity.city3;
    }
    @JavascriptInterface
    public String showCity4() {
        return ChangeActivity.city4;
    }
    @JavascriptInterface
    public String showCity5() {
        return ChangeActivity.city5;
    }
    @JavascriptInterface
    public void sendData(String data) {
        //Get the string value to process
        this.data = data;
        setThirdCity(data);
        //Toast.makeText(mContext, data, Toast.LENGTH_SHORT).show();
    }

    public void setThirdCity(String var){
        saveData = var;
        Toast.makeText(mContext, saveData, Toast.LENGTH_SHORT).show();
    }

    public static String getThirdCity()
    {
        return saveData;
    }
}


