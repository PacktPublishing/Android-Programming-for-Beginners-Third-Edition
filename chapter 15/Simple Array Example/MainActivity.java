package com.packtpub.simplearrayexample.simplearrayexample;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;


public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Declaring an array
        int[] ourArray;

        //Allocate memory for a maximum size of 5 elements
        ourArray = new int[5];

        //Initialize ourArray with values
        //The values are arbitrary as long as they are int
        //The indexes are not arbitrary 0 through 4 or crash!
        ourArray[0] = 25;
        ourArray[1] = 50;
        ourArray[2] = 125;
        ourArray[3] = 68;
        ourArray[4] = 47;

        //Output all the stored values
        Log.i("info", "Here is ourArray:");
        Log.i("info", "[0] = "+ourArray[0]);
        Log.i("info", "[1] = "+ourArray[1]);
        Log.i("info", "[2] = "+ourArray[2]);
        Log.i("info", "[3] = "+ourArray[3]);
        Log.i("info", "[4] = "+ourArray[4]);

        //We can do any calculation with an array element
        //As long as it is appropriate to the contained type
        //Like this:
        int answer = ourArray[0] +
                ourArray[1] +
                ourArray[2] +
                ourArray[3] +
                ourArray[4];

        Log.i("info", "Answer = "+answer);
    }



}
