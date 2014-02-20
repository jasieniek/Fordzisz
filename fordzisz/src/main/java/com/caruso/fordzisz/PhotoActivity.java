package com.caruso.fordzisz;

import android.app.WallpaperManager;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class PhotoActivity extends ActionBarActivity {

    private int photoResource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        Bundle bundle = getIntent().getExtras();
        int photoPosition = bundle.getInt("photoPosition");
        ImageView photoContainer = (ImageView) findViewById(R.id.photoContainer);
        TypedArray temp = getResources().obtainTypedArray(R.array.photoList);
        photoResource = temp.getResourceId(photoPosition, 0);
        photoContainer.setImageResource(photoResource);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.photo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void setAsBackgroundHandler(View view)
    {
        Log.d("debug", view.toString());
        WallpaperManager wpm = WallpaperManager.getInstance(this);
        try
        {
            wpm.setResource(photoResource);
            Toast.makeText(this, "New Background", Toast.LENGTH_SHORT).show();
        }
        catch (Exception e)
        {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }
    }
}
