package com.gamecodeschool.exploringlayouts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_menu);
    }

    public void loadConstraintLayout(View v){
        setContentView(R.layout.activity_main);
    }

    public void loadTableLayout(View v){
        setContentView(R.layout.my_table_layout);
    }

    public void loadMenuLayout(View v){
        setContentView(R.layout.main_menu);
    }
}