package com.gamecodeschool.inheritanceexample.app;

import android.util.Log;

public class Fighter extends AlienShip{

    public Fighter(){
        super(400);
        //Strong shields for a fighter
        Log.i("Location: ", "Fighter constructor");
    }

    public void fireWeapon(){
        Log.i("Firing weapon: ", "lasers firing");
    }

}
