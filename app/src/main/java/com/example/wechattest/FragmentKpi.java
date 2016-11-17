package com.example.wechattest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

/**
 * Created by saber on 2016/11/15.
 */

public class FragmentKpi extends Fragment {

    private WebView webView;

    private TextView tv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_kpi, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tv = (TextView) getView().findViewById(R.id.title_text);
        tv.setText("经营分析");
        init();
    }

    private void init(){
        webView = (WebView) getView().findViewById(R.id.web_view_kpi);

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);

        //WebView加载web资源
        webView.loadUrl("http://3zrbg.free.natapp.cc/bairuiwechatbi/main/menu/module/module.do?module=bairuichart/menu/perfomance/PerformanceAppraisal.html");

        //覆盖WebView默认使用第三方或系统默认浏览器打开网页的行为，使网页用WebView打开
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // TODO Auto-generated method stub
                //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
                view.loadUrl(url);
                return true;
            }
        });


    }

}
