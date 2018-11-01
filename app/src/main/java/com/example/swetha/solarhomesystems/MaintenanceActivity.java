package com.example.swetha.solarhomesystems;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class MaintenanceActivity extends AppCompatActivity {

    public String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintanence);


        final String spinnerArray[] = {"Panel", "Battery", "Output", "Connection"};
        ArrayAdapter<String> spinnerAdapter =new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,spinnerArray);
        spinnerAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        Spinner spinner = (Spinner)findViewById(R.id.issue_spinner);
        spinner.setAdapter(spinnerAdapter);

spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
       s = spinnerArray[position];

       // Log.d("insideListener", "onItemSelected: "+s);
       setIssue(s);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
});


        EditText desc_et = (EditText)findViewById(R.id.maintanence_desc_et);
       final String desc = desc_et.getText().toString();
        Button send = (Button) findViewById(R.id.issue_send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent IssueEmailIntent = new Intent(Intent.ACTION_SEND);
                IssueEmailIntent.setType("plain/text");
                IssueEmailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {"swetha.seelam12@gmail.com"});
                IssueEmailIntent.putExtra(Intent.EXTRA_SUBJECT,getIssue()+" issue with my Solar Home System" );
                IssueEmailIntent.putExtra(Intent.EXTRA_TEXT, desc);
                startActivity(Intent.createChooser(IssueEmailIntent,"Send email.."));
            }
        });


    }
String issue;
    private void setIssue(String s) {
       issue=s;
    }
    private String getIssue()
    {
        return issue;
    }
}
