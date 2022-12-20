package com.example.cheemsfm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Feedback extends AppCompatActivity {
    Button button;
    EditText URL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        button = findViewById(R.id.button18);
        URL = findViewById(R.id.editTextTextPersonName);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String URLtext = URL.getText().toString();
                String [] addresses = {"ankit.kr351104@gmail.com", "it2020054@rcciit.org.in"};
                //public void composeEmail(String[] addresses, String subject, Uri attachment) {
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("*/*");
                    intent.putExtra(Intent.EXTRA_EMAIL, addresses);
                    intent.putExtra(Intent.EXTRA_SUBJECT, "Feedback/Requesting a feature");
                    intent.putExtra(Intent.EXTRA_TEXT, URLtext);

                    //intent.putExtra(Intent.EXTRA_STREAM, attachment);
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }
                }

            });
        }
    }