package com.gamecodeschool.livedrawing;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;

import java.util.ArrayList;
import java.util.Random;

class ParticleSystem {

    private float mDuration;

    private ArrayList<Particle> mParticles;
    private Random random = new Random();
    boolean mIsRunning = false;

    void init(int numParticles){

        mParticles = new ArrayList<>();
        // Create the particles

        for (int i = 0; i < numParticles; i++){
            float angle = (random.nextInt(360)) ;
            angle = angle * 3.14f / 180.f;

            // Option 1 - Slow particles
            //float speed = (random.nextFloat()/10);

            // Option 2 - Fast particles
            float speed = (random.nextInt(10)+1);

            PointF direction;

            direction = new PointF((float)Math.cos(angle) * speed,
                    (float)Math.sin(angle) * speed);

            mParticles.add(new Particle(direction));
        }
    }

    void update(long fps){
        mDuration -= (1f/fps);

        for(Particle p : mParticles){
            p.update(fps);
        }

        if (mDuration < 0)
        {
            mIsRunning = false;
        }
    }


    void emitParticles(PointF startPosition){
        mIsRunning = true;

        // Option 1 - Sysstem lasts for half a minute
        //mDuration = 30f;

        // Option 2 - System lasts for 2 seconds
        mDuration = 3f;

        for(Particle p : mParticles){
            p.setPosition(startPosition);
        }

    }

    void draw(Canvas canvas, Paint paint){

        for (Particle p : mParticles) {

            // Option 1 - Coloured particles
            //paint.setARGB(255, random.nextInt(256),
            //random.nextInt(256),
            //random.nextInt(256));

            // Option 2 - White particles
            paint.setColor(Color.argb(255,255,255,255));


            // How big is each particle?
            float sizeX = 0;
            float sizeY = 0;

            // Option 1 - Big particles
            //sizeX = 25;
            //sizeY = 25;

            // Option 2 - Medium particles
            sizeX = 10;
            sizeY = 10;

            // Option 3 - Tiny particles
            //sizeX = 1;
            //sizeY = 1;

            // Draw the particle
            // Option 1 - Square particles
            //canvas.drawRect(p.getPosition().x,
            //p.getPosition().y,
            //p.getPosition().x + sizeX,
            //p.getPosition().y + sizeY,
            //paint);

            // Option 2 - Circle particles
            canvas.drawCircle(p.getPosition().x,
                    p.getPosition().y,
                    sizeX, paint);
        }
    }





}

