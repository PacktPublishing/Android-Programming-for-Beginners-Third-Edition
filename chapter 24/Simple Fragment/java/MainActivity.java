package com.gamecodeschool.simplefragment;

import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get a fragment manager
        FragmentManager fManager = getSupportFragmentManager();

        // Create a new fragment using the manager
        // Passing in the id of the layout to hold it
        Fragment frag = fManager.findFragmentById(R.id.fragmentHolder);

        // Check the fragment has not already been initialized
        if(frag == null){

            // Initialize the fragment based on our SimpleFragment
            frag  = new SimpleFragment();
            fManager.beginTransaction()
                    .add(R.id.fragmentHolder, frag)
                    .commit();

        }

    }
}