package com.snipclip.tc.snipclip;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class SnipClipActivity extends AppCompatActivity {


    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snip_clip);

        webView= (WebView) findViewById(R.id.webViewId);
        webView.getSettings().setJavaScriptEnabled(true);
        webView. setHorizontalScrollBarEnabled (true);
       // webView. getSettings().setJavaScriptCanOpenWindowsAutomatically (false);
        webView.getSettings().setBuiltInZoomControls(true);
        String newUA= "Mozilla/5.0 (X11; U; Linux i686; en-US; rv:1.9.0.4) Gecko/20100101 Firefox/4.0";
        newUA="Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0";
        newUA="Chrome";
        webView.getSettings().setUserAgentString(newUA);
        //webView.loadData("https://www.youtube.com","text/html","utf-8");
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url){
               // webView.loadUrl(url);
                // Here the String url hold 'Clicked URL'
                Toast.makeText(SnipClipActivity.this,url,Toast.LENGTH_LONG).show();
                return false;
            }

            @Override
            public void onLoadResource(WebView view, String url) {
                if( url.startsWith("https://www.youtube.com/watch?v=") ) {
                    // do something
                    Toast.makeText(SnipClipActivity.this, url, Toast.LENGTH_LONG).show();
                }

                    super.onLoadResource(view, url);
            }
        });

        webView.loadUrl("https://www.youtube.com");
    }
}
