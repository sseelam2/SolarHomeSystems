package com.example.swetha.solarhomesystems;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomListAdapter extends ArrayAdapter {
     private final Activity context;
     private final Integer[] imageIDArray;
     private final String[] nameArray;

//Constructor to set data
     public CustomListAdapter(Activity context, Integer[] imageIDArrayParam, String[] nameArrayParam)
     {
         super(context,R.layout.listview_row,nameArrayParam);
         this.context = context;
         this.imageIDArray =imageIDArrayParam;
         this.nameArray=nameArrayParam;

     }

     public View getView(int position, View view, ViewGroup parent)
     {
         LayoutInflater inflater = context.getLayoutInflater();
         View rowView = inflater.inflate(R.layout.listview_row, null, true);
         TextView name = (TextView)rowView.findViewById(R.id.nameTextView);
         ImageView image = (ImageView)rowView.findViewById(R.id.imageView1);
         name.setText(nameArray[position]);
         image.setImageResource(imageIDArray[position]);
         return  rowView;
     }
}
