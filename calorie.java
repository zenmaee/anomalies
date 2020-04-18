package com.example.anomaliesdraft;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

public class calorie extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.calories_page);

        Intent activityThatCalled = getIntent();

        String previousActivity = activityThatCalled.getExtras().getString("callingActivity");


    }
}