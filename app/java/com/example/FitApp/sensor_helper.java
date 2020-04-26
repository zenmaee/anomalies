package com.example.FitApp;

public class sensor_helper {

    private sensor_helper(){
    }

    public static float sum(float[] arr){
        float total_value = 0;
        for(int i=0;i<arr.length; i++){
            total_value += arr[i];
        }
        return total_value;
    }

    public static float[] cross_product(float[] arrA, float[] arrB){
        float[] newarr = new float[3];
        newarr[0] = arrA[1] * arrB[2] - arrA[2] * arrB[1];
        newarr[1] = arrA[2] * arrB[0] - arrA[0] * arrB[2];
        newarr[2] = arrA[0] * arrB[1] - arrA[1] * arrB[0];
        return newarr;
    }

    public static float norm(float[] arr){
        float norm = 0;
        for(int i=0; i<arr.length; i++){
            norm += arr[i] * arr[i];
        }
        return (float) Math.sqrt(norm);
    }

    public static float dot(float[] arrA, float[] arrB){
        float dot_solution = arrA[0] * arrB[0] + arrA[1] * arrB[1] + arrA[2] * arrB[2];
        return dot_solution;
    }

    public static float[] normalize(float[] arr){
        float[] norm_vec = new float[arr.length];
        float norm_val = norm(arr);
        for(int i=0; i<arr.length;i++){
            norm_vec[i] = arr[i] / norm_val;
        }
        return norm_vec;
    }



}
