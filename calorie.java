package com.example.MyApplication2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;


public class calorie extends Activity {

    //PRIVATIZE INFORMATION
    private TextView totalcals;
    private float num1,num2,num3,num4,num5;
    private Button calorietotal;
    private float runningtotal = 0;
    private EditText breakfastcals, lunchcals, dinnercals, snackcals,drinkcals;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.calories_page);


        //INITIALIZE UI CONNECTION
        calorietotal = (Button) findViewById(R.id.calorietotal);
        breakfastcals = (EditText) findViewById(R.id.breakfastcals);
        lunchcals = (EditText) findViewById(R.id.lunchcals);
        dinnercals = (EditText) findViewById(R.id.dinnercals);
        snackcals = (EditText) findViewById(R.id.snackcals);
        drinkcals = (EditText) findViewById(R.id.drinkcals);
        totalcals = (TextView) findViewById(R.id.totalcals);

        //PROCESS CALCULATION
        calorietotal.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                num1 = Integer.parseInt(breakfastcals.getText().toString());
                num2 = Integer.parseInt(lunchcals.getText().toString());
                num3 = Integer.parseInt(dinnercals.getText().toString());
                num4 = Integer.parseInt(snackcals.getText().toString());
                num5 = Integer.parseInt(drinkcals.getText().toString());
                runningtotal = num1 + num2 + num3 + num4 + num5;
                totalcals.setText(String.valueOf(runningtotal));
            }
        });


        Intent activityThatCalled = getIntent();
        String previousActivity = activityThatCalled.getExtras().getString("callingActivity");



    }
}