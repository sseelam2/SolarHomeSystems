package com.example.swetha.solarhomesystems;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class AsyncTaskForecast extends AsyncTask<Void, Void, String[]> {


ListView resLv;
    Activity con;
    int size=10;
Bitmap[] imageArray= new Bitmap[size];
    AsyncTaskForecast(ListView res,Activity con)
    {
        this.con =con;
        resLv=res;

    }

    @Override
    protected String[] doInBackground(Void... voids) {
// These two need to be declared outside the try/catch
// so that they can be closed in the finally block.
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        Log.d("tag", "doInBackground: ");
// Will contain the raw JSON response as a string.
        String forecastJsonStr = null;

        try {
            // Construct the URL for the OpenWeatherMap query
            // Possible parameters are avaiable at OWM's forecast API page, at
            // http://openweathermap.org/API#forecast
            URL url = new URL("http://api.openweathermap.org/data/2.5/forecast?zip=27606&APPID=8fb1be0a925374365946f9ec99483323");

            // Create the request to OpenWeatherMap, and open the connection
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            // Read the input stream into a String
            InputStream inputStream = urlConnection.getInputStream();
            StringBuffer buffer = new StringBuffer();
            if (inputStream == null) {
                // Nothing to do.
                forecastJsonStr = null;
            }
            reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                // Since it's JSON, adding a newline isn't necessary (it won't affect parsing)
                // But it does make debugging a *lot* easier if you print out the completed
                // buffer for debugging.
                buffer.append(line + "\n");
            }

            if (buffer.length() == 0) {
                // Stream was empty.  No point in parsing.
                forecastJsonStr = null;
            }
            forecastJsonStr = buffer.toString();

        } catch (IOException e) {
            Log.e("PlaceholderFragment", "Error ", e);
            // If the code didn't successfully get the weather data, there's no point in attemping
            // to parse it.
            forecastJsonStr = null;
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (final IOException e) {
                    Log.e("PlaceholderFragment", "Error closing stream", e);
                }
            }
        }


WeatherDataParser obj = new WeatherDataParser();
        Double[] tempArray= new Double[size];
        String[] rainArray = new String[size];
        String[] date = new String[size];
        String[] res = new String[size];
        for(int i =0;i<size;i++)
        tempArray[i]=obj.getTemp(forecastJsonStr,i);
        for(int i=0;i<size;i++)
            rainArray[i]=obj.getRain(forecastJsonStr,i);
        for(int i=0;i<size;i++)
            date[i]=obj.getDate(forecastJsonStr,i);
        for(int i=0;i<size;i++)
            res[i]=date[i]+"\n"+tempArray[i]+"\n"+rainArray[i];
        Log.d("BEforeIMage", "doInBackground: ");
        for(int i=0;i<size;i++)
            imageArray[i]=obj.getImage(forecastJsonStr,i);

        Log.d("ASYNCIMAGE", imageArray.toString());
        return res;
    }

    protected void onPostExecute(String[] s)
    {
        CustomWeatherAdapter weatherAdap = new CustomWeatherAdapter(con,s,imageArray);

        resLv.setAdapter(weatherAdap);
    }
}
