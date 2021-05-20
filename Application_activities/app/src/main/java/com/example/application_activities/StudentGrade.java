package com.example.application_activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;


public class StudentGrade extends AppCompatActivity {

    EditText txtDataReceived;
    Button btnDone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_grade);

        txtDataReceived = (EditText) findViewById(R.id.txtDataReceived);
        btnDone = findViewById(R.id.btnDone);
        btnDone.setOnClickListener(this::onClick);


        Intent myCallerIntent = getIntent();
        Bundle myBundle = myCallerIntent.getExtras();
        Double index = myBundle.getDouble("index");

        String Grade;
        if(index == 248992)
        {
            Grade = "4.5";

        }
        else
        {
            Grade = "3";

        }

        //myBundle.putString("grade", String.valueOf(4.5));
        txtDataReceived.setText("Received grade is: " + Grade);


        myBundle.putString("grade", Grade);

        myCallerIntent.putExtras(myBundle);
        setResult(MainActivity.RESULT_OK,
                myCallerIntent);


    }
    public void onClick(View v) {
        // close current screen - terminate StudentGrade Activity
        finish();
    }

}