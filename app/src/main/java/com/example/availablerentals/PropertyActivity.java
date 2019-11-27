package com.example.availablerentals;

//import android.support.v7.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PropertyActivity extends AppCompatActivity {
    ViewPagerAdapterActivity adapter;
    ViewPager viewPager;
    LinearLayout sliderDotspanel;
    private int dotsCount;
    private ImageView dots[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property);

        // set action bar icon
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        // create sharedPref editor
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

        // image
        viewPager = (ViewPager)findViewById(R.id.viewPager);
        // retrieve sharedPref
        int position = sharedPref.getInt("position",0);
        adapter = new ViewPagerAdapterActivity(PropertyActivity.this,Variables.Properties[position]);
        viewPager.setAdapter(adapter);

        // set text for address
        TextView txtPropertyAddress = (TextView)findViewById(R.id.txtPropertyAddress);
        txtPropertyAddress.setText(Variables.Addresses[position][0]);
        TextView txtPropertyZip = (TextView)findViewById(R.id.txtPropertyZip);
        txtPropertyZip.setText(Variables.Addresses[position][1]);
        TextView txtPropertyBeds = (TextView)findViewById(R.id.txtPropertyBeds);
        txtPropertyBeds.setText(Variables.Unitsizes[position][0] + "/" + Variables.Unitsizes[position][1]);
        TextView txtPropertyPrice = (TextView)findViewById(R.id.txtPropertyPrice);
        txtPropertyPrice.setText(Variables.Unitsizes[position][2]);

        // slide dots
        sliderDotspanel = (LinearLayout)findViewById(R.id.SliderDots);
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
