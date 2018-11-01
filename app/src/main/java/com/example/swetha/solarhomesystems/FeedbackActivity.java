package com.example.swetha.solarhomesystems;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FeedbackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);



       final EditText feedbackText = (EditText)findViewById(R.id.editText3);
        Button sendButton =(Button)findViewById(R.id.email_send_button);


        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  String mailto = "mailto:swetha.seelam12@gmail.com" + "&body=" + Uri.encode(feedbackText.getText().toString());
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setType("plain/text");
                emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"swetha.seelam12@gmail.com"});
                emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Comments/Feedback");
                emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, feedbackText.getText().toString());
                startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            }
        });


    }


}
