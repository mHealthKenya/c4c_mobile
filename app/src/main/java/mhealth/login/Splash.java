package mhealth.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);

                    startActivity(new Intent(Splash.this, SignInActivity.class));
                    finish();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
