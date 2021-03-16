package com.gamecodeschool.accessscopethisandstatic;

import android.util.Log;

public class AlienShip {
    private static int numShips;
    private int shieldStrength;
    public String shipName;

    public AlienShip(){
        numShips++;
        //Can call private methods from here because I am part
        //of the class
        //If didn't have "this" then this call might be less clear
        //But this "this" isn't strictly necessary
        this.setShieldStrength(100);
        //Because of "this" I am sure I am setting the correct shieldStrength
    }

    public static int getNumShips(){
        return numShips;

    }

    private void setShieldStrength(int shieldStrength){
        //"this" distinguishes between the member variable shieldStrength
        //And the local variable/paramater of the same name
        this.shieldStrength = shieldStrength;
    }


    public int getShieldStrength(){
        return this.shieldStrength;
    }

    public void hitDetected(){

        shieldStrength -=25;
        Log.i("Incomiming: ","Bam!!");
        if (shieldStrength == 0){
            destroyShip();
        }

    }

    private void destroyShip(){
        numShips--;
        Log.i("Explosion: ", ""+this.shipName + " destroyed");
    }
}
