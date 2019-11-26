package com.example.availablerentals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // set text for address
        int position = 3;
        TextView txtPropertyAddress = (TextView)findViewById(R.id.txtSpecialAddress);
        txtPropertyAddress.setText(Variables.Addresses[position][0]);
        TextView txtPropertyZip = (TextView)findViewById(R.id.txtSpecialZip);
        txtPropertyZip.setText(Variables.Addresses[position][1]);
        TextView txtPropertyBeds = (TextView)findViewById(R.id.txtSpecialBed);
        txtPropertyBeds.setText(Variables.Unitsizes[position][0] + "/" + Variables.Unitsizes[position][1]);
        TextView txtPropertyPrice = (TextView)findViewById(R.id.txtSpecialPrice);
        txtPropertyPrice.setText(Variables.Unitsizes[position][2]);

        // set timer to close activity
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                finish();
                startActivity(new Intent(SplashActivity.this, PropertyBadgeActivity.class));
            }
        };

        Timer opening = new Timer();
        opening.schedule(task,3000);
    }
}
