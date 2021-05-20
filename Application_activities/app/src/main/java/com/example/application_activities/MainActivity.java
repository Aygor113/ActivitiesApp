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



public class MainActivity extends AppCompatActivity {


    Button buttonCall;
    EditText txtCall;
    Button buttonOpenWensite;
    EditText txtWebsite;
    Button buttonShowOnMap;
    EditText txtMap;
    Button buttonSendIndex;
    EditText txtIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtCall = (EditText)findViewById(R.id.txtCall);
        buttonCall = findViewById(R.id.btnCall);
        buttonCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String callStr = "tel: ";
                callStr += txtCall.getText().toString();
                Intent intentCall = new Intent(Intent.ACTION_DIAL);
               // intentCall.setData(Uri.parse("tel: 123456789"));
                intentCall.setData(Uri.parse(callStr));
                startActivity(intentCall);
            }
        });
        txtWebsite = (EditText)findViewById(R.id.txtWebsite);
        buttonOpenWensite = findViewById(R.id.btnOpenWeb);
        buttonOpenWensite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String websiteStr = "http://";
                websiteStr += txtWebsite.getText().toString();
                Intent intentOpenWeb = new Intent(Intent.ACTION_VIEW);
                //intentOpenWeb.setData(Uri.parse("http://www.pwr.edu.pl"));
                intentOpenWeb.setData(Uri.parse(websiteStr));

                startActivity(intentOpenWeb);
            }
        });

        txtMap = (EditText)findViewById(R.id.txtMap);
        buttonShowOnMap = findViewById(R.id.btnShowMap);
        buttonShowOnMap.setOnClickListener(new View.OnClickListener() {
            //Uri mapLocation = Uri.parse("geo: 51.10943, 17.05962");

            public void onClick(View v) {
                String mapStr = "geo:0,0?q=1600 ";
                mapStr += txtMap.getText().toString();
                Uri mapLocation = Uri.parse(mapStr);

                Intent intentShowMap = new Intent(Intent.ACTION_VIEW, mapLocation);
                intentShowMap.setPackage("com.google.android.apps.maps");
                startActivity(intentShowMap);
            }
        });

        txtIndex = (EditText)findViewById(R.id.txtIndex);
        buttonSendIndex = findViewById(R.id.btnSendIdx);
        buttonSendIndex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double index = Double.parseDouble(txtIndex.getText().toString());
                Intent intentIndex = new Intent(MainActivity.this, StudentGrade.class);
                Bundle myDataBundle = new Bundle();
                myDataBundle.putDouble("index", index);
                intentIndex.putExtras(myDataBundle);
                startActivityForResult(intentIndex, 101);

            }
        });
    }
    // local listener receives callbacks from other activities
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if ((requestCode == 101 ) && (resultCode == Activity.RESULT_OK)){
            Bundle myResultBundle = data.getExtras();
            String  myResult = myResultBundle.getString("grade");
            txtIndex.setText("Grade is " + myResult);
        }

    }//onActivityResult

}