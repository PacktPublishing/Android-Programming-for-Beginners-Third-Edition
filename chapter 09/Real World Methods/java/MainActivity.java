package com.gamecodeschool.realworldmethods;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String joinedString = joinThese("Methods ", "are ", "cool ");
        Log.e("joinedString = ","" + joinedString);

        float area  = getAreaCircle(5f);
        Log.e("area = ","" + area);

        int a = 0;
        changeA(a);
        Log.e("a = ","" + a);

    }

    String  joinThese(String a, String b, String c){
        return a + b + c;
    }

    float getAreaCircle(float radius){

        return 3.141f * radius * radius;

    }

    void changeA(int a){
        a++;

    }
}
