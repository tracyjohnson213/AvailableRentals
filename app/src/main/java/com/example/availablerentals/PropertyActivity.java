package com.example.availablerentals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class PropertyActivity extends AppCompatActivity {
    Integer[] Properties = {
            R.drawable.e3rdst1162livingroom,
            R.drawable.e4thst3225livingroom,
            R.drawable.eoceanblvd1075front,
            R.drawable.molinaave908livingroom,
            R.drawable.walnutave589front
    };
    String[] Addresses = {
            "1162 E 3rd St",
            " 3225 E 4th St",
            R.drawable.eoceanblvd1075front,
            R.drawable.molinaave908livingroom,
            R.drawable.walnutave589front
    };
    ImageView pic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property);

        GridView grid = (GridView)findViewById(R.id.gridView);
        final ImageView pic = (ImageView)findViewById(R.id.imgLarge);

        grid.setAdapter(new ImageAdapter(this));

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(),"Selected Property " + (position+1),Toast.LENGTH_SHORT).show();
                pic.setImageResource(Properties[position]);
            }
        });
    }

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
            pic.setLayoutParams(new GridView.LayoutParams(330,300));
            return pic;
        }
    }
}
