package com.example.myapplication;

public class Detecting {

    //ACCELEROMETER INITIALIZATION
    private static int accel_ring_const = 50;
    private int accel_ring_count = 0;
    private float[] accel_X = new float[accel_ring_const];
    private float[] accel_Y = new float[accel_ring_const];
    private float[] accel_Z = new float[accel_ring_const];

    //VELOCITY INITIALIZATION
    private static int velocity_ring_const = 10;
    private int velocity_ring_count = 0;
    private float[] velocity_ring = new float[velocity_ring_const];
    private float velocity_estimate_old = 0;

    //STEP TIMING
    private static int steps_delay = 30005000;
    private static float step_detect = 75f;
    private long last_step_time = 0;

    //INTERFACES
    private step_listening listening;

    public void registerListener(step_listening listening){
        this.listening = listening;
    }

    public void update_accelerometer(long time, float X, float Y, float Z){
        //TEMP STORAGE
        float[] current_acceleration = new float[3];
        float[] irl_Z = new float[3];
        float norm_factorizer;
        float velocity_estimate;
        float current_Z;

        //UPDATE COUNTERS
        current_acceleration[0] = X;
        current_acceleration[1] = Y;
        current_acceleration[2] = Z;


        //GUESS WHERE Z IS?
        accel_ring_count++;
        accel_X[accel_ring_count%accel_ring_const] = current_acceleration[0];
        accel_Y[accel_ring_count%accel_ring_const] = current_acceleration[1];
        accel_Z[accel_ring_count%accel_ring_const] = current_acceleration[2];
        irl_Z[0] = sensor_helper.sum(accel_X)/Math.min(accel_ring_count, accel_ring_const);
        irl_Z[1] = sensor_helper.sum(accel_Y)/Math.min(accel_ring_count, accel_ring_const);
        irl_Z[2] = sensor_helper.sum(accel_Z)/Math.min(accel_ring_count, accel_ring_const);


        //NORMALIZED VECTOR USED TO FIND THE ESTIMATION
        norm_factorizer = sensor_helper.norm(irl_Z);

        //UPDATE VECTORS TO NORM VECTOR
        irl_Z[0] = irl_Z[0] / norm_factorizer;
        irl_Z[1] = irl_Z[1] / norm_factorizer;
        irl_Z[2] = irl_Z[2] / norm_factorizer;

        //UPDATE CURRENT Z
        current_Z = sensor_helper.dot(irl_Z, current_acceleration) - norm_factorizer;


        //UPDATE VELOCITY
        velocity_ring_count++;
        velocity_ring[velocity_ring_count%velocity_ring_const] = current_Z;
        velocity_estimate = sensor_helper.sum(velocity_ring);

        //CHECK ESTIMATE IN COMPARISON TO OLD ESTIMATE
        if(velocity_estimate > step_detect){
            if(velocity_estimate_old <= step_detect){
                if(time - last_step_time > steps_delay){
                    listening.step(time);
                    last_step_time = time;
                }
            }
        }

        //FINALLY UPDATE OLD VELOCITY
        velocity_estimate_old = velocity_estimate;
    }
}
