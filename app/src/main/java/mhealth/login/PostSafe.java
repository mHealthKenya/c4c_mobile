package mhealth.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class PostSafe extends AppCompatActivity {

    WebView webView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_safe);

        webView4 =findViewById(R.id.postSafeID);
        webView4.setWebViewClient(new WebViewClient());

        webView4.getSettings().setJavaScriptEnabled(true);
        webView4.getSettings().setLoadsImagesAutomatically(true);
        webView4.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);


        webView4.loadUrl("http://survey.mhealthkenya.co.ke/survey/post-safe-phlebotomy-training-test/view/11");
    }
}