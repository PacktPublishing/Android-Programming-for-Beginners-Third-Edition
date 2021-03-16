package com.gamecodeschool.switchdemo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		

        // get input from user in a String variable called command
        String command = "ofolof";

        switch(command){

            case "go east":
                Log.i("Player: ", "Moves to the east");
                break;

            case "go west":
                Log.i("Player: ", "Moves to the East" );

                break;

            case "go north":
                Log.i("Player: ", "Moves to the North" );

                break;

            case "go south":
                Log.i("Player: ", "Moves to the South" );

                break;

            case "Take sword":
                Log.i("Player: ", "Takes the silver sword" );

                break;

            // more possible cases

            default:
                Log.i("Message: ", "Sorry I don't speak Elfish" );
                break;

        }


    }
}
