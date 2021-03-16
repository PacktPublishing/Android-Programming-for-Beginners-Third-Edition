package com.packtpub.gettersandsetters.app;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Soldier mySoldier = new Soldier();
        //mySoldier.health = 100;//Doesn't work private
        //we can use the public getter setHealth()
        mySoldier.setHealth(100);//That's better
        Log.i("Just set health to 100 = ", ""+mySoldier.getHealth());


        Hospital militaryHospital = new Hospital();

        //Oh no mySoldier has been wounded
        mySoldier.setHealth(10);
        Log.i("Just got wounded to 10 = ", ""+mySoldier.getHealth());

        //Take him to the hospital
        //But my health variable is private
        //And Hospital won't be able to access it
        //I'm doomed - tell Laura I love her

        //No wait- what about my public getters and setters?
        //We can use the public getters and setters from another method

        militaryHospital.healSoldier(mySoldier);
        Log.i("Back from the militaryHospital = ", ""+mySoldier.getHealth());
        //mySoldiers private variable health has been increased by 10
        //I'm feeling much better thanks!

    }

}
