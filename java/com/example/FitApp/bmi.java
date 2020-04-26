package com.example.FitApp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class bmi extends Activity {

    //PRIVATIZE INFORMATION
    private TextView bmi_display;
    private EditText height, weight;
    private Button calc_bmi;
    private float num1, num2, result;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi);


        //INITIATE THE UI CONNECTION
        height = (EditText) findViewById(R.id.height);
        weight = (EditText) findViewById(R.id.weight);
        calc_bmi = (Button) findViewById(R.id.calc_bmi);
        bmi_display = (TextView) findViewById(R.id.bmi_display);

        //PROCESS CALCULATION
        calc_bmi.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                num1 = Integer.parseInt(height.getText().toString());
                num2 = Integer.parseInt(weight.getText().toString());
                result = num2 / (num1*num1);
                bmi_display.setText(String.valueOf(result*10000));
            }
        });


        Intent activityThatCalled = getIntent();
        String previousActivity = activityThatCalled.getExtras().getString("callingActivity");

    }
}
