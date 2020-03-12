package com.example.lx.common;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MyWebView extends WebView {
    private String css_str;
    private Context context;


    public MyWebView(Context context) {
        super(context);
        initView(context,null);
    }

    public MyWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context,attrs);
    }

    public MyWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context,attrs);
    }

    public MyWebView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context,attrs);
    }

    private void initView(Context context,AttributeSet attrs){
        this.context = context;
        WebSettings webSettings = this.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBuiltInZoomControls(true);
    }

    public void loadData(String data){

    }
}
