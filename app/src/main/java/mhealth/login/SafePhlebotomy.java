package mhealth.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class SafePhlebotomy extends AppCompatActivity {

    WebView webView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safe_phlebotomy);

        webView3 = findViewById(R.id.webSafePhle);
        webView3.setWebViewClient(new WebViewClient());

        webView3.getSettings().setJavaScriptEnabled(true);
        webView3.getSettings().setLoadsImagesAutomatically(true);
        webView3.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);


        webView3.loadUrl("http://survey.mhealthkenya.co.ke/survey/safe-phlebotomy-training-workshop-evaluation/view/10");
    }
}