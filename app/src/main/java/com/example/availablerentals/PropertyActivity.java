package com.example.availablerentals;

//import android.support.v7.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

public class PropertyActivity extends AppCompatActivity {
    private int[] images = {
            R.drawable.e3rdst1162livingroom,
            R.drawable.e3rdst1162kitchen,
            R.drawable.e3rdst1162bath,
            R.drawable.e3rdst1162bed
    };
    ViewPagerAdapterActivity adapter;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property);

        viewPager = (ViewPager)findViewById(R.id.viewPager);
        adapter = new ViewPagerAdapterActivity(PropertyActivity.this,images);
        viewPager.setAdapter(adapter);
    }
}
//https://www.youtube.com/watch?v=SX8l9vv-N_4
