package com.caruso.fordzisz;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.shapes.Shape;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import org.apache.http.util.EncodingUtils;

/**
 * Created by Caruso on 12.02.14.
 */
public class ImageAdapter extends BaseAdapter {

    private Context mContext;
    private TypedArray tab;

    public ImageAdapter(Context c)
    {
        mContext = c;
        tab = mContext.getResources().obtainTypedArray(R.array.photoList);
    }

    public int getCount() {
        return tab.length();
    }

    public Object getItem(int position) {
        return tab.getResourceId(position, 0);
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(200, 200));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setBackgroundResource(R.xml.textview_background);
            //imageView.setPadding(10, 10, 10, 10);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(tab.getResourceId(position, 0));
        return imageView;
    }
}
