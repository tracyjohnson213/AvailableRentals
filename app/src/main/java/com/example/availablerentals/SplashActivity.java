package com.example.availablerentals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // set text for address in position for special property
        int special = 3;
        TextView txtPropertyAddress = (TextView)findViewById(R.id.txtSpecialAddress);
        txtPropertyAddress.setText(Variables.Address[special][0]);
        TextView txtPropertyZip = (TextView)findViewById(R.id.txtSpecialZip);
        txtPropertyZip.setText(Variables.Address[special][1]);
        TextView txtPropertyBeds = (TextView)findViewById(R.id.txtSpecialBed);
        txtPropertyBeds.setText(Variables.Unitsize[special][0] + "/" + Variables.Unitsize[special][1]);
        TextView txtPropertyPrice = (TextView)findViewById(R.id.txtSpecialPrice);
        txtPropertyPrice.setText(Variables.Unitsize[special][2]);

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

        // rotate text
        TextView txtRotate = (TextView)findViewById(R.id.txtOne);
        txtRotate.startAnimation(AnimationUtils.loadAnimation(this,R.anim.rotatation));
    }
}
