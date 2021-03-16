package com.gamecodeschool.inheritanceexample.app;

import android.util.Log;

public class Bomber extends AlienShip {

    public Bomber(){
        super(100);
        //Weak shields for a bomber
        Log.i("Location: ", "Bomber constructor");
    }

    public void fireWeapon(){
        Log.i("Firing weapon: ", "bombs away");
    }
}
