package com.example.MyApplication2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    Button bmi, water, calorie, steps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toWater(View view) {
        Intent getNameScreenIntent = new Intent(this, water.class);

        getNameScreenIntent.putExtra("callingActivity", "MainActivity");
        startActivity(getNameScreenIntent);
    }

    public void toCalorie(View view) {
        Intent getNameScreenIntent = new Intent(this, calorie.class);

        getNameScreenIntent.putExtra("callingActivity", "MainActivity");
        startActivity(getNameScreenIntent);
    }

    public void toBMI(View view) {
        Intent getNameScreenIntent = new Intent(this, bmi.class);

        getNameScreenIntent.putExtra("callingActivity", "MainActivity");
        startActivity(getNameScreenIntent);
    }


    public void toSteps(View view) {
        Intent getNameScreenIntent = new Intent(this, steps.class);

        getNameScreenIntent.putExtra("callingActivity", "MainActivity");
        startActivity(getNameScreenIntent);
    };






}