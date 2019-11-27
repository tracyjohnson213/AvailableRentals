package com.example.availablerentals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.availablerentals.Variables.*;

public class PropertyBadgeActivity extends AppCompatActivity {
    ImageView pic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_badge);

        // set action bar icon
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        // create sharedPref editor
        final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

        // go to property activity after click of large image
        ImageView viewPropertyImages = (ImageView)findViewById(R.id.imgLarge);
        viewPropertyImages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PropertyBadgeActivity.this,PropertyActivity.class));
            }
        });

        // create grid of photos and large image
        GridView grid = (GridView)findViewById(R.id.gridView);
        final ImageView pic = (ImageView)findViewById(R.id.imgLarge);

        grid.setAdapter(new ImageAdapter(this));

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView txtClickImage = (TextView)findViewById(R.id.txtClickImage);
                txtClickImage.setText("Click large image to see more photos");
                TextView txtPropertyAddress = (TextView)findViewById(R.id.txtPropertyInfo);
                txtPropertyAddress.setText(Address[position][0]+ "  - Long Beach, CA " + Address[position][1]);
                TextView txtPropertyUnit = (TextView)findViewById(R.id.txtPropertyInfo2);
                txtPropertyUnit.setText(Unitsize[position][0]+ "/" + Unitsize[position][1] + " " + Unitsize[position][2]);

                pic.setImageResource(PropertyImage[position][0]);

                // set sharedPref editor
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("position", position);
                editor.commit();
            }
        });
    }

    // trigger for large image from selected photo in grid
    public class ImageAdapter extends BaseAdapter {
        private Context context;
        public ImageAdapter(Context c) {
            context = c;
        }

        @Override
        public int getCount(){
            return PropertyImage.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            pic = new ImageView(context);
            pic.setImageResource(PropertyImage[position][0]);
            pic.setScaleType(ImageView.ScaleType.FIT_XY);
            pic.setLayoutParams(new GridView.LayoutParams(500,250));
            return pic;
        }
    }

    // TODO if Properties.length > 6 display next button when displaying 1 to 6
    // TODO if Properties.length > 6 display prev button when displaying Properties > 6
}
