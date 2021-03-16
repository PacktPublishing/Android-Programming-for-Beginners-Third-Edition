package com.gamecodeschool.basicclasses;

import android.util.Log;


public class Soldier {
    int health;
    String soldierType;

    void shootEnemy(){
        //let's print which type of soldier is shooting
        Log.i(soldierType, " is shooting");
    }

}
