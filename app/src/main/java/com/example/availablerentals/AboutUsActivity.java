package com.example.availablerentals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AboutUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        // set home page icon launcher
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        // go to property badge activity after click of button
        Button viewRentalsButton = (Button)findViewById(R.id.btnViewRentals);
        viewRentalsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AboutUsActivity.this,PropertyBadgeActivity.class));
            }
        });

        // go to rental criteria activity after click of button
        Button rentalCriteriaButton = (Button)findViewById(R.id.btnViewRentalCriteria);
        rentalCriteriaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AboutUsActivity.this,RentalCriteriaActivity.class));
            }
        });

        // go to email form activity after click of button
        Button emailButton = (Button)findViewById(R.id.btnEmail);
        emailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AboutUsActivity.this,EmailFormActivity.class));
            }
        });
    }
}
