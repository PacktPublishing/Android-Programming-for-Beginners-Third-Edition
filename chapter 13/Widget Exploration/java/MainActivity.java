package com.gamecodeschool.widgetexploration;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.PorterDuff;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextClock;
import android.widget.TextView;


import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Get a reference to all our widgets

        RadioGroup radioGroup = 
                findViewById(R.id.radioGroup);


        final EditText editText =
                findViewById(R.id.editText);

        final Button button =
                findViewById(R.id.button);

        final TextClock tClock =
                findViewById(R.id.textClock);

        final CheckBox cbTransparency =
                findViewById(R.id.checkBoxTransparency);

        final CheckBox cbTint =
                findViewById(R.id.checkBoxTint);
				
        final CheckBox cbReSize =
                findViewById(R.id.checkBoxReSize);

        final ImageView imageView =
                findViewById(R.id.imageView);

        Switch switch1 = 
				findViewById(R.id.switch1);
				
        final TextView textView =
                 findViewById(R.id.textView);

        // Hide the TextView at the start of the app
        textView.setVisibility(View.INVISIBLE);




        /*
        Now we need to listen for clicks
        on the button, the CheckBoxes
        and the RadioButtons
        */

        // First the check boxes using an anonymous class
        cbTransparency.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {

              public void onCheckedChanged(
                      CompoundButton buttonView, boolean isChecked) {

                  if (cbTransparency.isChecked()) {
                      // Set some transparency
                      imageView.setAlpha(.1f);
                  } else {
                      imageView.setAlpha(1f);
                  }

              }
          });

        // Now the next checkbox
        cbTint.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {

          public void onCheckedChanged(CompoundButton
                                               buttonView, boolean isChecked) {

              if (cbTint.isChecked()) {
                  // Checked so set some tint
                  imageView.setColorFilter(
                          Color.argb(150, 255, 0, 0));

              } else {
                  // No tint needed
                  imageView.setColorFilter(Color.argb(0, 0, 0, 0));
              }

          }
        });



        // And the last check box
        cbReSize.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(
                    CompoundButton buttonView, boolean isChecked) {

                if (cbReSize.isChecked()) {
                    // It's checked so make bigger
                    imageView.setScaleX(2);
                    imageView.setScaleY(2);
                } else {
                    // It's not checked make regular size
                    imageView.setScaleX(1);
                    imageView.setScaleY(1);
                }

            }
        });


        // Now for the radio buttons
        // Uncheck all buttons
        radioGroup.clearCheck();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(
                    RadioGroup group, int checkedId) {

                RadioButton rb = (RadioButton)
                        group.findViewById(checkedId);


                switch (rb.getId()) {

                    case R.id.radioButtonLondon:
                        tClock.setTimeZone("Europe/London");
                        break;

                    case R.id.radioButtonBeijing:
                        tClock.setTimeZone("Etc/GMT-8");
                        break;

                    case R.id.radioButtonNewYork:

                        tClock.setTimeZone(
                                "America/New_York");
                        break;



                }// End switch block
            }
        });


        /*
       Let's listen for clicks on our "Capture" Button.
       We can do this with an anonymous class as well.
       An interface seems a bit much for one button.
       */
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // We only handle one button
                // So, no switching required

                // Change the text on the TextView
                // to whatever is currently in the EditText
                textView.setText(editText.getText());
            }
        });

        // Show or hide the TextView
        switch1.setOnCheckedChangeListener(
            new CompoundButton.OnCheckedChangeListener() {

                public void onCheckedChanged(
                        CompoundButton buttonView, boolean isChecked) {

                    if(isChecked){
                        textView.setVisibility(View.VISIBLE);
                    }else{
                        textView.setVisibility(View.INVISIBLE);
                    }
                }
            });


        WebView webView = findViewById(R.id.webView);
        webView.loadUrl("https://gamecodeschool.com");
    }
}