package com.example.listview2;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
 
public class GalleryAdapter extends BaseAdapter
{
    Context context;
    Integer[] images;
    String []names;
    TextView imageName;

    public GalleryAdapter(Context context,Integer []images,String []names)
    {
        this.context = context;
        this.images=images;
        this.names=names;
    }


    public int getCount() {
        return this.images.length;
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }


    // Override this method according to your need
    public View getView(int index, View view, ViewGroup viewGroup)
    {
        // TODO Auto-generated method stub
        ImageView i = new ImageView(context);

        i.setImageResource(this.images[index]);
        i.setLayoutParams(new Gallery.LayoutParams(70, 70));
           
        i.setScaleType(ImageView.ScaleType.FIT_XY);
        
        
        return i;
    }
  
}