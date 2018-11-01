package com.example.swetha.solarhomesystems;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomWeatherAdapter extends ArrayAdapter {
    private final Activity context;
    String[] weatherData;
    Bitmap[] imagebm;


    public CustomWeatherAdapter(Activity context,String[] weatherData, Bitmap[] bmImage)
    {
        super(context, R.layout.weather_row , weatherData );
        this.context=context;
        this.weatherData=weatherData;
        this.imagebm=bmImage;
    }

    public View getView(int position, View view, ViewGroup parent)
    {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.weather_row, null, true);
        TextView name = (TextView)rowView.findViewById(R.id.weatherTv);
        ImageView image = (ImageView)rowView.findViewById(R.id.imageWeather);
        name.setText(weatherData[position]);
        image.setImageBitmap(imagebm[position]);
        return  rowView;
    }





}
