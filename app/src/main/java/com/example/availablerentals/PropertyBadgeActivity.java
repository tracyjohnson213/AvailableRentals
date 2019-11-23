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

public class PropertyBadgeActivity extends AppCompatActivity {
    // TODO move global variables to external file
    //  TODO rename variable to property*photo*
    Integer[] Properties = {
            R.drawable.e3rdst1162livingroom,
            R.drawable.e4thst3225livingroom,
            R.drawable.eoceanblvd1075front,
            R.drawable.molinaave908livingroom,
            R.drawable.walnutave589front
    };
    // TODO move global variables to external file
    String[] Addresses = {
            "1162 E 3rd St",
            "3225 E 4th St",
            "1075 E Ocean Blvd",
            "908 Molina Ave",
            "589 Walnut Ave"
    };
    ImageView pic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_badge);

        // go to property activity after click of button
        Button listViewButton = (Button)findViewById(R.id.btnList);
        listViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PropertyBadgeActivity.this,PropertyListActivity.class));
            }
        });

        // create grid of photos and large image
        GridView grid = (GridView)findViewById(R.id.gridView);
        final ImageView pic = (ImageView)findViewById(R.id.imgLarge);

        grid.setAdapter(new ImageAdapter(this));

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(),
                        "Property: " + (Addresses[position] + "  - Long Beach, CA"),
                        Toast.LENGTH_SHORT).show();
                pic.setImageResource(Properties[position]);
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
            return Properties.length;
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
            pic.setImageResource(Properties[position]);
            pic.setScaleType(ImageView.ScaleType.FIT_XY);
            pic.setLayoutParams(new GridView.LayoutParams(500,300));
            return pic;
        }
    }

    // TODO if Properties.length > 6 display next button when displaying 1 to 6
    // TODO if Properties.length > 6 display prev button when displaying Properties > 6
}
