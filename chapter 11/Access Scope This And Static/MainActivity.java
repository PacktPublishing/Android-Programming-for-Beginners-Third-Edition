package com.gamecodeschool.accessscopethisandstatic;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //every time we do this the constructor runs
        AlienShip girlShip = new AlienShip();
        AlienShip boyShip = new AlienShip();

        //Look no objects but using the static method
        Log.i("numShips: ", "" + AlienShip.getNumShips());

        //This works because shipName is public
        girlShip.shipName = "Corrine Yu";
        boyShip.shipName = "Andre LaMothe";

        //This won't work because shieldStrenth is private
        //girlship.shieldStrength = 999;

        //But we have a public getter
        Log.i("girlShip shields: ", "" + girlShip.getShieldStrength());
        Log.i("boyShip shields: ", "" + boyShip.getShieldStrength());

        //But we can't do this because it's private
        //boyship.setShieldStrength(1000000);

        //lets shoot some ships
        girlShip.hitDetected();
        Log.i("girlShip shields: ", "" + girlShip.getShieldStrength());
        Log.i("boyShip shields: ", "" + boyShip.getShieldStrength());
        boyShip.hitDetected();
        boyShip.hitDetected();
        boyShip.hitDetected();
        Log.i("girlShip shields: ", "" + girlShip.getShieldStrength());
        Log.i("boyShip shields: ", "" + boyShip.getShieldStrength());
        boyShip.hitDetected();//ahhh
        Log.i("girlShip shields: ", "" + girlShip.getShieldStrength());
        Log.i("boyShip shields: ", "" + boyShip.getShieldStrength());
        Log.i("numShips: ", "" + AlienShip.getNumShips());
    }

}
