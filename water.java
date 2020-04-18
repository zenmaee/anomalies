package com.example.anomaliesdraft;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

public class water extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.water);

        Intent activityThatCalled = getIntent();

        String previousActivity = activityThatCalled.getExtras().getString("callingActivity");


    }
}