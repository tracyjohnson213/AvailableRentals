package com.example.availablerentals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CosignersCriteriaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cosigners_criteria);

        // go to rental criteria activity after click of button
        Button prevButton = (Button)findViewById(R.id.btnRentalCriteria2);
        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CosignersCriteriaActivity.this, EmploymentCriteriaActivity.class));
            }
        });
    }
}
