package com.example.availablerentals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EmploymentCriteriaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employment_criteria);

        // set home page icon launcher
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        // go to rental criteria activity after click of button
        Button prevButton = (Button)findViewById(R.id.btnRentalCriteria1);
        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EmploymentCriteriaActivity.this, RentalCriteriaActivity.class));
            }
        });

        // go to third rental criteria activity after click of button
        Button nextButton = (Button)findViewById(R.id.btnRentalCriteria3);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EmploymentCriteriaActivity.this, CosignersCriteriaActivity.class));
            }
        });
    }
}
