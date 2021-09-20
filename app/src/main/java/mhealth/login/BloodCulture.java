package mhealth.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class BloodCulture extends AppCompatActivity {
    WebView webView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_culture);


        webView2 = findViewById(R.id.BloodCulture);
        webView2.setWebViewClient(new WebViewClient());

        webView2.getSettings().setJavaScriptEnabled(true);
        webView2.getSettings().setLoadsImagesAutomatically(true);
        webView2.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);


        webView2.loadUrl("https://survey.mhealthkenya.co.ke/survey/blood-culture-specimen-management-enhancing-healthcare-workers-and-patients-safety/view/13");

    }
}