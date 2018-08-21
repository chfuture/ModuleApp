package com.ycwang.mylib1.webUrl;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.WebView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.ycwang.mylib1.R;

/**
 * @author ycwang.
 * @date 2018-8-20.
 */
// 模拟Web页面
@Route(path = "/web/WebActivity")
public class WebActivity extends Activity {

    WebView webView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        webView = findViewById(R.id.web);

        webView.loadData("<h2>1:URL普通跳转</h2>\n" +
                "\n" +
                "<p><a href=\"guotongshiyou://ycwang/web/NoCanReceiveURLActivity\">guotongshiyou://ycwang/web/NoCanReceiveURLActivity </a>\n" +
                "</p>\n" +
                "\n" +
                "<h2>2:URL普通跳转携带参数</h2>\n" +
                "\n" +
                "<p>\n" +
                "<a href=\"guotongshiyou://ycwang/web/HasCanReceiveURLActivity?name=alex&age=18&boy=true&high=180&obj=%7b%22name%22%3a%22jack%22%2c%22id%22%3a666%7d\">guotongshiyou://ycwang/web/HasCanReceiveURLActivity?name=alex&age=18&boy=true&high=180&obj={\"name\":\"jack\",\"id\":\"666\"}\n" +
                "</a>\n" +
                "</p>", "text/html;charset=utf-8", "utf-8");
    }
}
