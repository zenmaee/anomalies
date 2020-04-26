package com.example.MyApplication2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class water extends Activity {

    //PRIVATIZE VARIABLES
    private TextView water_total;
    private float num1;
    private float runningtotal = 0;
    private Button oz8, oz16, oz20, oz32;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.water);

        //INITIATE THE UI CONNECTION
        oz8 = (Button) findViewById(R.id.oz8);
        oz16 = (Button) findViewById(R.id.oz16);
        oz20 = (Button) findViewById(R.id.oz20);
        oz32 = (Button) findViewById(R.id.oz32);
        water_total = (TextView) findViewById(R.id.water_total) ;


        //SETUP ALL BUTTONS
        oz8.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

                num1 = 8;
                runningtotal = runningtotal + num1;
                String temp_string = String.valueOf(runningtotal*29.57) + "ml";
                water_total.setText(temp_string);
            }
        });
        oz16.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

                num1 = 8;
                runningtotal = runningtotal + num1;
                String temp_string = String.valueOf(runningtotal*29.57) + "ml";
                water_total.setText(temp_string);
            }
        });
        oz20.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

                num1 = 20;
                runningtotal = runningtotal + num1;
                String temp_string = String.valueOf(runningtotal*29.57) + "ml";
                water_total.setText(temp_string);
            }
        });
        oz32.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

                num1 = 32;
                runningtotal = runningtotal + num1;
                String temp_string = String.valueOf(runningtotal*29.57) + "ml";
                water_total.setText(temp_string);
            }
        });

        
        Intent activityThatCalled = getIntent();
        String previousActivity = activityThatCalled.getExtras().getString("callingActivity");


    }
}
