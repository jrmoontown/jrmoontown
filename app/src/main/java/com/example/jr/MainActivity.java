package com.example.jr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private android.webkit.WebView WebView;
    private String url = "192.168.219.106";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView = (WebView)findViewById(R.id.WebView);
        WebView.getSettings().setJavaScriptEnabled(true);
        WebView.loadUrl(url);
        WebView.setWebChromeClient(new WebChromeClient());
        WebView.setWebViewClient(new WebViewClientClass());

        Button btn = (Button)findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WebView.loadUrl("192.168.219.106/on");
            }

        });

        Button btn_off = (Button)findViewById(R.id.btn_off);
        btn_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WebView.loadUrl("192.168.219.106/off");
            }

        });


    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if((keyCode == KeyEvent.KEYCODE_BACK)&& WebView.canGoBack()){
            WebView.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }


    private class WebViewClientClass extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(android.webkit.WebView view, String url) {
            view.loadUrl(url);

            return true;
        }
    }


}