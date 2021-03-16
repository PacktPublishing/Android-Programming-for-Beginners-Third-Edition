package com.gamecodeschool.animationdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Animation.AnimationListener {

    Animation animFadeIn;
    Animation animFadeOut;
    Animation animFadeInOut;

    Animation animZoomIn;
    Animation animZoomOut;

    Animation animLeftRight;
    Animation animRightLeft;
    Animation animTopBottom;

    Animation animBounce;
    Animation animFlash;

    Animation animRotateLeft;
    Animation animRotateRight;


    ImageView imageView;
    TextView textStatus;

    Button btnFadeIn;
    Button btnFadeOut;
    Button btnFadeInOut;
    Button zoomIn;
    Button zoomOut;
    Button leftRight;
    Button rightLeft;
    Button topBottom;
    Button bounce;
    Button flash;
    Button rotateLeft;
    Button rotateRight;
    SeekBar seekBarSpeed;
    TextView textSeekerSpeed;

    int seekSpeedProgress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadAnimations();
        loadUI();

    }

    private void loadAnimations(){
        animFadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        animFadeIn.setAnimationListener(this);
        animFadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out);
        animFadeInOut = AnimationUtils.loadAnimation(this, R.anim.fade_in_out);

        animZoomIn = AnimationUtils.loadAnimation(this, R.anim.zoom_in);
        animZoomOut = AnimationUtils.loadAnimation(this, R.anim.zoom_out);

        animLeftRight = AnimationUtils.loadAnimation(this, R.anim.left_right);
        animRightLeft = AnimationUtils.loadAnimation(this, R.anim.right_left);
        animTopBottom = AnimationUtils.loadAnimation(this, R.anim.top_bot);

        animBounce = AnimationUtils.loadAnimation(this, R.anim.bounce);
        animFlash = AnimationUtils.loadAnimation(this, R.anim.flash);

        animRotateLeft = AnimationUtils.loadAnimation(this, R.anim.rotate_left);
        animRotateRight = AnimationUtils.loadAnimation(this, R.anim.rotate_right);
    }

    private void loadUI() {


        imageView = findViewById(R.id.imageView);
        textStatus = findViewById(R.id.textStatus);

        btnFadeIn = findViewById(R.id.btnFadeIn);
        btnFadeOut = findViewById(R.id.btnFadeOut);
        btnFadeInOut = findViewById(R.id.btnFadeInOut);
        zoomIn = findViewById(R.id.btnZoomIn);
        zoomOut = findViewById(R.id.btnZoomOut);
        leftRight = findViewById(R.id.btnLeftRight);
        rightLeft = findViewById(R.id.btnRightLeft);
        topBottom = findViewById(R.id.btnTopBottom);
        bounce = findViewById(R.id.btnBounce);
        flash = findViewById(R.id.btnFlash);
        rotateLeft = findViewById(R.id.btnRotateLeft);
        rotateRight = findViewById(R.id.btnRotateRight);

        btnFadeIn.setOnClickListener(this);
        btnFadeOut.setOnClickListener(this);
        btnFadeInOut.setOnClickListener(this);
        zoomIn.setOnClickListener(this);
        zoomOut.setOnClickListener(this);
        leftRight.setOnClickListener(this);
        rightLeft.setOnClickListener(this);
        topBottom.setOnClickListener(this);
        bounce.setOnClickListener(this);
        flash.setOnClickListener(this);
        rotateLeft.setOnClickListener(this);
        rotateRight.setOnClickListener(this);

        seekBarSpeed = findViewById(R.id.seekBarSpeed);
        textSeekerSpeed = findViewById(R.id.textSeekerSpeed);

        seekBarSpeed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int value, boolean fromUser) {
                seekSpeedProgress = value;
                textSeekerSpeed.setText("" + seekSpeedProgress + " of " + seekBarSpeed.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        textStatus.setText("STOPPED");

    }

    @Override
    public void onAnimationRepeat(Animation animation) {


    }

    @Override
    public void onAnimationStart(Animation animation) {
        textStatus.setText("RUNNING");

    }

    @Override
    public void onClick(View v) {


        switch(v.getId()){
            case R.id.btnFadeIn:
                animFadeIn.setDuration(seekSpeedProgress);
                animFadeIn.setAnimationListener(this);
                imageView.startAnimation(animFadeIn);

                break;

            case R.id.btnFadeOut:

                animFadeOut.setDuration(seekSpeedProgress);
                animFadeOut.setAnimationListener(this);
                imageView.startAnimation(animFadeOut);

                break;

            case R.id.btnFadeInOut:

                animFadeInOut.setDuration(seekSpeedProgress);
                animFadeInOut.setAnimationListener(this);
                imageView.startAnimation(animFadeInOut);

                break;

            case R.id.btnZoomIn:
                animZoomIn.setDuration(seekSpeedProgress);
                animZoomIn.setAnimationListener(this);
                imageView.startAnimation(animZoomIn);

                break;

            case R.id.btnZoomOut:
                animZoomOut.setDuration(seekSpeedProgress);
                animZoomOut.setAnimationListener(this);
                imageView.startAnimation(animZoomOut);

                break;



            case R.id.btnLeftRight:
                animLeftRight.setDuration(seekSpeedProgress);
                animLeftRight.setAnimationListener(this);
                imageView.startAnimation(animLeftRight);

                break;

            case R.id.btnRightLeft:
                animRightLeft.setDuration(seekSpeedProgress);
                animRightLeft.setAnimationListener(this);
                imageView.startAnimation(animRightLeft);

                break;

            case R.id.btnTopBottom:
                animTopBottom.setDuration(seekSpeedProgress);
                animTopBottom.setAnimationListener(this);
                imageView.startAnimation(animTopBottom);

                break;

            case R.id.btnBounce:
		/*
		   Divide seekSpeedProgress by 10 because with
		   the seekbar having a max value of 5000 it
		   will make the animations range between
		   almost instant and half a second
		   5000 /  10 = 500 milliseconds
		*/
                animBounce.setDuration(seekSpeedProgress / 10);
                animBounce.setAnimationListener(this);
                imageView.startAnimation(animBounce);

                break;

            case R.id.btnFlash:
                animFlash.setDuration(seekSpeedProgress / 10);
                animFlash.setAnimationListener(this);
                imageView.startAnimation(animFlash);

                break;

            case R.id.btnRotateLeft:
                animRotateLeft.setDuration(seekSpeedProgress);
                animRotateLeft.setAnimationListener(this);
                imageView.startAnimation(animRotateLeft);

                break;

            case R.id.btnRotateRight:
                animRotateRight.setDuration(seekSpeedProgress);
                animRotateRight.setAnimationListener(this);
                imageView.startAnimation(animRotateRight);

                break;
        }

    }

}