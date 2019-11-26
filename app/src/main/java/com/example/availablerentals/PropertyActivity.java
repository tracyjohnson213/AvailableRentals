package com.example.availablerentals;

//import android.support.v7.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class PropertyActivity extends AppCompatActivity {
    private int[] images = {
            R.drawable.e3rdst1162livingroom,
            R.drawable.e3rdst1162kitchen,
            R.drawable.e3rdst1162bath,
            R.drawable.e3rdst1162bed
    };
    ViewPagerAdapterActivity adapter;
    ViewPager viewPager;
    LinearLayout sliderDotspanel;
    private int dotsCount;
    private ImageView dots[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property);

        // image
        viewPager = (ViewPager)findViewById(R.id.viewPager);
        sliderDotspanel = (LinearLayout)findViewById(R.id.SliderDots);
        adapter = new ViewPagerAdapterActivity(PropertyActivity.this,images);
        viewPager.setAdapter(adapter);

        dotsCount = adapter.getCount();
        dots = new ImageView[dotsCount];

        for (int i=0; i < dotsCount; i++) {
            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.non_active_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(8,0,8,0);
            sliderDotspanel.addView(dots[i],params);
        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.active_dot));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i=0; i < dotsCount; i++) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.non_active_dot));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.active_dot));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
//https://www.youtube.com/watch?v=SX8l9vv-N_4
//http://www.sanktips.com/2017/10/01/how-to-add-dots-indicator-to-image-slider-with-viewpager-in-android-studio/
