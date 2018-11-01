package com.example.swetha.solarhomesystems;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;

public class WeatherDataParser {
static Double min;
public static String des;
static String icon;
static Bitmap bmp;
static String date;

    public static double getTemp(String weatherJsonStr, int dayIndex) {
        try {
            JSONObject weather = new JSONObject(weatherJsonStr);
            JSONArray days = weather.getJSONArray("list");
            Log.d("weatherP", days.toString());
            JSONObject dayinfo = days.getJSONObject(dayIndex);
            Log.d("dayInfo",dayinfo.toString());
             JSONObject minTemp = dayinfo.getJSONObject("main");
             min = minTemp.getDouble("temp");

        } catch (Exception e) {

        }
      return min;

    }

    public static String getRain(String weatherJSONStr, int dayIndex)
    {
        Log.d("Rain", "getRain: ");
        try{
            Log.d("Raindescription1", "rain");
            JSONObject weather = new JSONObject(weatherJSONStr);
            Log.d("Raindescription2", "rain");
            JSONArray days = weather.getJSONArray("list");
            Log.d("Raindescription3", "rain");
            JSONObject dayinfo = days.getJSONObject(dayIndex);
           // Log.d("Raindescription4", dayinfo.toString());
            JSONArray weatherDisplay = dayinfo.getJSONArray("weather");
            //Log.d("Raindescription5", weatherDisplay.toString());
             des = weatherDisplay.getJSONObject(0).getString("description");
            //rain = des.getString("description");
            Log.d("Raindescription6", des);
        }
        catch(Exception e)
        {

        }
        return des ;
    }

    public static Bitmap getImage(String weatherJSONStr, int dayIndex)
    {
        try{
            JSONObject weather = new JSONObject(weatherJSONStr);
            JSONArray days = weather.getJSONArray("list");
            JSONObject dayinfo = days.getJSONObject(dayIndex);
            JSONArray weatherDisplay = dayinfo.getJSONArray("weather");
            icon = weatherDisplay.getJSONObject(0).getString("icon");
            URL url = new URL("http://openweathermap.org/img/w/" + icon + ".png");
             bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            Log.d("IMAAAAAGGEEEEE", "getImage:"+url);
        }
        catch(Exception e)
        {

        }
return bmp;
    }

    public static String getDate(String weatherJSONStr, int dayIndex)
    {
        try
        {
            JSONObject weather = new JSONObject(weatherJSONStr);
            JSONArray days = weather.getJSONArray("list");
            JSONObject dayinfo = days.getJSONObject(dayIndex);

             date = dayinfo.getString("dt_txt");

        }
        catch(Exception e)
        {

        }
        return date;
    }
}
