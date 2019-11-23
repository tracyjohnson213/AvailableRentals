package com.example.availablerentals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // set home page icon launcher
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        // go to splash activity after click of button
        Button viewRentalsButton = (Button)findViewById(R.id.btnViewRentals);
        viewRentalsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SplashActivity.class));
            }
        });

        // go to rental criteria activity after click of button
        Button rentalCriteriaButton = (Button)findViewById(R.id.btnViewRentalCriteria);
        rentalCriteriaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,RentalCriteriaActivity.class));
            }
        });

        // go to about us activity after click of button
        Button aboutUsButton = (Button)findViewById(R.id.btnAboutUs);
        aboutUsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,AboutUsActivity.class));
            }
        });

        // go to email form activity after click of button
        Button emailButton = (Button)findViewById(R.id.btnEmail);
        emailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,EmailFormActivity.class));
            }
        });
    }
}
