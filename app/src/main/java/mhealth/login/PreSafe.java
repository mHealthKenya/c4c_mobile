package mhealth.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class PreSafe extends AppCompatActivity {

    WebView webView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_safe);

        webView1 = findViewById(R.id.WebPreSafe);
        webView1.setWebViewClient(new WebViewClient());

        webView1.getSettings().setJavaScriptEnabled(true);
        webView1.getSettings().setLoadsImagesAutomatically(true);
        webView1.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);


        webView1.loadUrl("http://survey.mhealthkenya.co.ke/survey/pre-safe-phlebotomy-training-test/view/1");
    }
}