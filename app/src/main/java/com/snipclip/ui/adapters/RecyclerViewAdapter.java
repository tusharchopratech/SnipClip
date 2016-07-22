package com.snipclip.ui.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;


import com.snipclip.R;

import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by tc on 5/9/16.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.VideoHolder>{

    Context context;
    View view;
    ArrayList<String> urls;
    int flag=1;

    RecyclerViewAdapter(ArrayList<String> urls , Context context)
    {
        this.urls=urls;
        this.context=context;
    }


    public class VideoHolder extends RecyclerView.ViewHolder {

        WebView webView;
        Button buttonPause,buttonStop;
        LinearLayout linearLayout;

        public VideoHolder(View itemView) {
            super(itemView);
            view=itemView;
            webView= (WebView) itemView.findViewById(R.id.webViewId);
            buttonPause= (Button) itemView.findViewById(R.id.buttonPauseId);
            buttonStop= (Button) itemView.findViewById(R.id.buttonStopId);
            linearLayout= (LinearLayout) itemView.findViewById(R.id.linearLayoutId);
        }
    }
    @Override
    public void onBindViewHolder(final VideoHolder videoHolder, final int i) {

        videoHolder.webView.getSettings().setJavaScriptEnabled(true);
        videoHolder.webView.addJavascriptInterface(new WebAppInterface(context,videoHolder.linearLayout), "Android");
        videoHolder.webView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url){
                return false;
            }
        });

        String html=getHtmlInString("video_iframe.html");
        html=html.replaceAll("%YOUTUBE_VIDEO%",urls.get(i));
        videoHolder.webView.loadDataWithBaseURL("file:///android_asset/video_iframe.html",html,"text/html","utf-8",null);


        flag=1;
        videoHolder.buttonPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag == 1) {
                    videoHolder.webView.loadUrl("javascript:pauseVideo()");
                    videoHolder.buttonPause.setText("Resume");
                } else {
                    videoHolder.webView.loadUrl("javascript:playVideo()");
                    videoHolder.buttonPause.setText("Pause");
                }

                if (flag == 1) {
                    flag = 0;
                } else {
                    flag = 1;
                }
            }

        });

        videoHolder.buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                videoHolder.webView.loadUrl("javascript:stopVideo()");
                videoHolder.linearLayout.setVisibility(View.GONE);
            }
        });

    }


    @Override
    public VideoHolder onCreateViewHolder(ViewGroup viewGroup, final int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.inflate_video_webview, viewGroup, false);
        return new VideoHolder(itemView);
    }


    @Override
    public int getItemCount() {
        return urls.size();
    }

    public String getHtmlInString(String fileName) {

        try {
            InputStream is = context.getAssets().open(fileName);
            int size = is.available();

            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            String str = new String(buffer);
            //str = str.replace("old string", "new string");

            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

     public class WebAppInterface {

        Context mContext;
        LinearLayout linearLayout;
        WebAppInterface(Context c,LinearLayout linearLayout) {
            mContext = c;
            this.linearLayout=linearLayout;
        }

        @JavascriptInterface
        public void showController() {
            ((Activity)context).runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    linearLayout.setVisibility(View.VISIBLE);
                }
            });
        }
    }

}


