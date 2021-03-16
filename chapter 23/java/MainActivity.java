package com.gamecodeschool.sounddemo;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    SoundPool sp;

    int idFX1 = -1;
    int idFX2 = -1;
    int idFX3 = -1;
    int nowPlaying = -1;

    float volume = .1f;
    int repeats = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonFX1 = findViewById(R.id.btnFX1);
        buttonFX1.setOnClickListener(this);

        Button buttonFX2 = findViewById(R.id.btnFX2);
        buttonFX2.setOnClickListener(this);

        Button buttonFX3 = (findViewById(R.id.btnFX3));
        buttonFX3.setOnClickListener(this);

        Button buttonStop = findViewById(R.id.btnStop);
        buttonStop.setOnClickListener(this);


        // Instantiate our sound pool dependent upon which version of Android
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes. USAGE_ASSISTANCE_SONIFICATION)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();

            sp = new SoundPool.Builder()
                    .setMaxStreams(5)
                    .setAudioAttributes(audioAttributes)
                    .build();
        } else {
            sp = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
        }

        try{
            // Create objects of the 2 required classes
            AssetManager assetManager = this.getAssets();
            AssetFileDescriptor descriptor;

            // Load our fx in memory ready for use
            descriptor = assetManager.openFd("fx1.ogg");
            idFX1 = sp.load(descriptor, 0);

            descriptor = assetManager.openFd("fx2.ogg");
            idFX2 = sp.load(descriptor, 0);

            descriptor = assetManager.openFd("fx3.ogg");
            idFX3 = sp.load(descriptor, 0);


        }catch(IOException e){
            // Print an error message to the console
            Log.e("error", "failed to load sound files");
        }

        // Now setup the seekbar
        SeekBar seekBar = findViewById(R.id.seekBar);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int value, boolean fromUser) {
                volume = value / 10f;
                sp.setVolume(nowPlaying, volume, volume);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        // Now for the spinner
        final Spinner spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String temp = String.valueOf(spinner.getSelectedItem());
                repeats = Integer.valueOf(temp);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }

        });


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btnFX1:
                sp.stop(nowPlaying);
                nowPlaying = sp.play(idFX1, volume,
                        volume, 0, repeats, 1);
                break;

            case R.id.btnFX2:
                sp.stop(nowPlaying);
                nowPlaying = sp.play(idFX2,
                        volume, volume, 0, repeats, 1);
                break;

            case R.id.btnFX3:
                sp.stop(nowPlaying);
                nowPlaying = sp.play(idFX3,
                        volume, volume, 0, repeats, 1);
                break;

            case R.id.btnStop:
                sp.stop(nowPlaying);
                break;
        }
    }
}