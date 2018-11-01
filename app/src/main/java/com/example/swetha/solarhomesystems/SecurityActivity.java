package com.example.swetha.solarhomesystems;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class SecurityActivity extends Activity {
public String email;
    final Calendar myCalendar = Calendar.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security);

        EditText edittext= (EditText) findViewById(R.id.security_date_et);
        EditText desc = (EditText) findViewById(R.id.security_desc_et);
        Button send_btn =(Button) findViewById(R.id.send_button);
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(android.widget.DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };

        edittext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(SecurityActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        final String msg = desc.getText().toString();

send_btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent securityIntent = new Intent(Intent.ACTION_SEND);
        securityIntent.setType("Plain/text");
        securityIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {"swetha.seelam12@gmail.com"});
        securityIntent.putExtra(Intent.EXTRA_SUBJECT, "Security");
        securityIntent.putExtra(Intent.EXTRA_TEXT,msg);
        startActivity(Intent.createChooser(securityIntent,"Send email.."));
    }
});
        }

    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        EditText edittext= (EditText) findViewById(R.id.security_date_et);
        edittext.setText(sdf.format(myCalendar.getTime()));
    }

    }


