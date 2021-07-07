package mhealth.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class HealthCareW extends AppCompatActivity {
    WebView webView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_care_w);
        webView2 =findViewById(R.id.HealthCW);

        webView2.setWebViewClient(new WebViewClient());

        webView2.getSettings().setJavaScriptEnabled(true);
        webView2.getSettings().setLoadsImagesAutomatically(true);
        webView2.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);

        webView2.loadUrl("http://survey.mhealthkenya.co.ke/survey/healthcare-worker-survey/view/9");
    }
}