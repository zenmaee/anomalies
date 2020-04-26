package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener, step_listening {
    private Sensor accelerometer;
    private SensorManager sensorManager;
    private Detecting step_detect;
    private int number_of_steps;
    private Button start, finish;
    private TextView display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //CREATE INSTANCE OF SENSOR MANAGER
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        step_detect = new Detecting();
        step_detect.registerListener(this);

        //INITIALIZE USER INTERFACE
        start = (Button) findViewById(R.id.start);
        finish = (Button) findViewById(R.id.finish);
        display = (TextView) findViewById(R.id.display);

        //SET UP START
        start.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                number_of_steps = 0;
                sensorManager.registerListener(MainActivity.this,accelerometer,SensorManager.SENSOR_DELAY_FASTEST);
            }
        });

        //SET UP FINISH
        finish.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                sensorManager.unregisterListener(MainActivity.this);
            }

        });

    }

    //HERE SO SENSOR EVENT LISTENER DOES NOT HAVE A STROKE
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy){
    }

    //CREATE CALL TO CHECK IF WE ARE MOVING
    @Override
    public void onSensorChanged(SensorEvent event){
        if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
            step_detect.update_accelerometer(event.timestamp,event.values[0],event.values[1],event.values[2]);
        }
    }

    //UPDATE NUMBER OF STEPS
    @Override
    public void step(long time){
        number_of_steps++;
        display.setText(String.valueOf(number_of_steps));
    }
}
