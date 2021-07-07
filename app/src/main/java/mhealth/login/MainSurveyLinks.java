package mhealth.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainSurveyLinks extends AppCompatActivity {

    TextView Linkone, Linktwo, Linkthree , Linkfour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_survey_links);

        Linkone = findViewById(R.id.preSafe);
        Linktwo = findViewById(R.id.HealthCare);
        Linkthree = findViewById(R.id.Safe);
        Linkfour = findViewById(R.id.postSafe);


        Linkone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://survey.mhealthkenya.co.ke/survey/pre-safe-phlebotomy-training-test/view/1")));
                Intent intent = new Intent(MainSurveyLinks.this, PreSafe.class);
                startActivity(intent);
            }
        });

        Linktwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://survey.mhealthkenya.co.ke/survey/healthcare-worker-survey/view/9")));
                Intent intent = new Intent(MainSurveyLinks.this, HealthCareW.class);
                startActivity(intent);


            }
        });

        Linkthree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               // startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://survey.mhealthkenya.co.ke/survey/safe-phlebotomy-training-workshop-evaluation/view/10")));
                Intent intent = new Intent(MainSurveyLinks.this, SafePhlebotomy.class);
                startActivity(intent);


            }
        });

        Linkfour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               // startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://survey.mhealthkenya.co.ke")));

                Intent intent = new Intent(MainSurveyLinks.this, PostSafe.class);
                startActivity(intent);

            }
        });
    }
}