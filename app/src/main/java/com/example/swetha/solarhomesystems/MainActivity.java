package com.example.swetha.solarhomesystems;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    String[] nameArray = {"Support","Weather","Payment","Information","Feedback"};

    Integer[] imageArray = {R.drawable.product_data,R.drawable.weather,R.drawable.payment,R.drawable.contact,R.drawable.feedback };
    ListView ls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CustomListAdapter listAdap = new CustomListAdapter(this,imageArray,nameArray);
        ls = (ListView)findViewById(R.id.lst_options);
        ls.setAdapter(listAdap);

        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0)
                {
                    Intent information_intent = new Intent(view.getContext(),SupportActivity.class);
                    startActivity(information_intent);

                }
                else if(position==1)
                {
                    Intent weather_intent = new Intent(view.getContext(),WeatherActivity.class);
                    startActivityForResult(weather_intent,1);

                }
                else if(position==4)
                {
                    Intent feedback_intent = new Intent(view.getContext(),FeedbackActivity.class);
                    startActivity(feedback_intent);

                }
            }
        });

       }


    }





