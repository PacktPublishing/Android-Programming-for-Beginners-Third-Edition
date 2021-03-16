package com.gamecodeschool.javameetui;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener{

    // An int variable to hold a value
    private int value = 0;

    // A bunch of Buttons and a TextView
    private Button btnAdd;
    private Button btnTake;
    private TextView txtValue;
    private Button btnGrow;
    private Button btnShrink;
    private Button btnReset;
    private Button btnHide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get a reference to all the buttons in our UI
        // Match them up to all our Button objects we declared earlier
        btnAdd = findViewById(R.id.btnAdd);
        btnTake = findViewById(R.id.btnTake);
        txtValue = findViewById(R.id.txtValue);
        btnGrow = findViewById(R.id.btnGrow);
        btnShrink = findViewById(R.id.btnShrink);
        btnReset = findViewById(R.id.btnReset);
        btnHide = findViewById(R.id.btnHide);

        // Listen for all the button clicks
        btnAdd.setOnClickListener(this);
        btnTake.setOnClickListener(this);
        txtValue.setOnClickListener(this);
        btnGrow.setOnClickListener(this);
        btnShrink.setOnClickListener(this);
        btnReset.setOnClickListener(this);
        btnHide.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        // A local variable to use later
        float size;

        switch(view.getId()){
            case R.id.btnAdd:
                value ++;
                txtValue.setText(""+ value);

                break;

            case R.id.btnTake:
                value--;
                txtValue.setText(""+ value);

                break;

            case R.id.btnReset:
                value = 0;
                txtValue.setText(""+ value);

                break;

            case R.id.btnGrow:
                size = txtValue.getTextScaleX();
                txtValue.setTextScaleX(size + 1);

                break;

            case R.id.btnShrink:
                size = txtValue.getTextScaleX();
                txtValue.setTextScaleX(size - 1);

                break;

            case R.id.btnHide:
                if(txtValue.getVisibility() == View.VISIBLE)
                {
                    // Currently visible so hide it
                    txtValue.setVisibility(View.INVISIBLE);

                    // Change text on the button
                    btnHide.setText("SHOW");

                }else{
                    // Currently hidden so show it
                    txtValue.setVisibility(View.VISIBLE);

                    // Change text on the button
                    btnHide.setText("HIDE");
                }


                break;



        }


    }
}