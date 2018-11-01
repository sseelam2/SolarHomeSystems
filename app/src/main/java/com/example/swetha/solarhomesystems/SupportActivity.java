package com.example.swetha.solarhomesystems;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class SupportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);
        ArrayList<String> supportListArray = new ArrayList<String>();
        supportListArray.add("Maintenance Request");
        supportListArray.add("Security Request");

        ArrayAdapter<String> sAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,supportListArray);
        ListView lv = (ListView)findViewById(R.id.support_list);
        lv.setAdapter(sAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0)
                {
                    Intent maintenance_intent = new Intent(view.getContext(), MaintenanceActivity.class);
                    startActivity(maintenance_intent);

                }
                else if(position==1)
                {
                    Intent security_intent = new Intent(view.getContext(),SecurityActivity.class);
                    startActivity(security_intent);
                }
            }
        });

    }
}
