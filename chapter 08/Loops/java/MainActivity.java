package com.gamecodeschool.loops;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void countUp(View v){
        Log.i("message:","In countUp method");

        int x = 0;

        // Now an apparently infinite while loop
        while(true){

            // Add 1 to x each time
            x++;
            Log.i("x =", "" + x);

            if(x == 3){
                // Get me out of here
                break;
            }
        }
    }

    public void countDown(View v){
        Log.i("message:","In countDown method");

        int x = 4;
        // Now an apparently infinite while loop
        while(true){

            // Add 1 to x each time
            x--;
            Log.i("x =", "" + x);

            if(x == 1){
                // Get me out of here
                break;
            }
        }
    }

    public void nested(View v){
        Log.i("message:","In nested method");

        // a nested for loop
        for(int i = 0; i < 3; i ++){

            for(int j = 3; j > 0; j --){

                // Output the values of i and j
                Log.i("i =" + i,"j=" + j);
            }
        }
    }



}