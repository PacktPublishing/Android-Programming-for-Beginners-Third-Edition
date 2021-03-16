package com.packtpub.gettersandsetters.app;

import android.util.Log;


class Hospital{
    protected void healSoldier(Soldier soldierToHeal){
        Log.i("Just arrived at healSoldier method = ", "" + soldierToHeal.getHealth());
        int health = soldierToHeal.getHealth();
        health = health + 10;
        soldierToHeal.setHealth(health);
        Log.i("Just finnishing heal soldier method = ", "" + soldierToHeal.getHealth());
    }
}
