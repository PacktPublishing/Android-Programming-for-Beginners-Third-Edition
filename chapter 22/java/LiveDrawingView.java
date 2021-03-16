package com.gamecodeschool.livedrawing;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;

class LiveDrawingView extends SurfaceView implements Runnable{

    // Are we debugging?
    private final boolean DEBUGGING = true;

    // These objects are needed to do the drawing
    private SurfaceHolder mOurHolder;
    private Canvas mCanvas;
    private Paint mPaint;

    // How many frames per second did we get?
    private long mFPS;
    // The number of milliseconds in a second
    private final int MILLIS_IN_SECOND = 1000;

    // Holds the resolution of the screen
    private int mScreenX;
    private int mScreenY;
    // How big will the text be?
    private int mFontSize;
    private int mFontMargin;

    // Here is the Thread and two control variables
    private Thread mThread = null;
    // This volatile variable can be accessed
    // from inside and outside the thread
    private volatile boolean mDrawing;
    private boolean mPaused = true;



    // The particle systems will be declared here later
    private ArrayList<ParticleSystem>
            mParticleSystems = new ArrayList<>();

    private int mNextSystem = 0;
    private final int MAX_SYSTEMS = 1000;
    private int mParticlesPerSystem = 100;



    // These will be used to make simple buttons
    private RectF mResetButton;
    private RectF mTogglePauseButton;


    // The LiveDrawingView constructor
    // Called when this line:
    // mLiveDrawingView = new LiveDrawingView(this, size.x, size.y);
    // is executed from LiveDrawingActivity
    public LiveDrawingView(Context context, int x, int y) {
        // Super... calls the parent class
        // constructor of SurfaceView
        // provided by the Android API
        super(context);

        // Initialize these two members/fields
        // With the values passed in as parameters
        mScreenX = x;
        mScreenY = y;

        // Font is 5% (1/20th) of screen width
        mFontSize = mScreenX / 20;
        // Margin is 1.5% (1/75th) of screen width
        mFontMargin = mScreenX / 75;

        // getHolder is a method of SurfaceView
        mOurHolder = getHolder();
        mPaint = new Paint();

        // Initialize the two buttons
        mResetButton = new RectF(0, 0, 100, 100);
        mTogglePauseButton = new RectF(0, 150, 100, 250);

        // Initialize the particles and their systems
        for (int i = 0; i < MAX_SYSTEMS; i++) {
            mParticleSystems.add(new ParticleSystem());
            mParticleSystems.get(i).init(mParticlesPerSystem);
        }


    }

    // When we start the thread with:
    // mThread.start();
    // the run method is continuously called by Android
    // because we implemented the Runnable interface
    // Calling mThread.join();
    // will stop the thread
    @Override
    public void run() {
        // mDrawing gives us finer control
        // rather than just relying on the calls to run
        // mDrawing must be true AND
        // the thread running for the main
        // loop to execute
        while (mDrawing) {

            // What time is it now at the start of the loop?
            long frameStartTime = System.currentTimeMillis();

            // Provided the app isn't paused
            // call the update method
            if(!mPaused){
                update();
                // Now the particles are in
                // their new positions

            }

            // The movement has been handled and now
            // we can draw the scene.
            draw();

            // How long did this frame/loop take?
            // Store the answer in timeThisFrame
            long timeThisFrame =
                    System.currentTimeMillis() - frameStartTime;

            // Make sure timeThisFrame is at least 1 millisecond
            // because accidentally dividing
            // by zero crashes the app
            if (timeThisFrame > 0) {
                // Store the current frame rate in mFPS
                // ready to pass to the update methods of
                // of our particles in the next frame/loop
                mFPS = MILLIS_IN_SECOND / timeThisFrame;
            }
        }
    }

    private void update() {
        // Update the particles
        for (int i = 0; i < mParticleSystems.size(); i++) {
            if (mParticleSystems.get(i).mIsRunning) {
                mParticleSystems.get(i).update(mFPS);
            }
        }


    }


    // Draw the particle systems and the HUD
    private void draw() {
        if (mOurHolder.getSurface().isValid()) {
            // Lock the canvas (graphics memory) ready to draw
            mCanvas = mOurHolder.lockCanvas();

            // Fill the screen with a solid color
            mCanvas.drawColor(Color.argb(255, 0, 0, 0));

            // Choose a color to paint with
            mPaint.setColor(Color.argb(255, 255, 255, 255));

            // Choose the font size
            mPaint.setTextSize(mFontSize);

            // Draw the particle systems
            for (int i = 0; i < mNextSystem; i++) {

                mParticleSystems.get(i).draw(mCanvas, mPaint);

            }


            // Draw the buttons
            mCanvas.drawRect(mResetButton, mPaint);
            mCanvas.drawRect(mTogglePauseButton, mPaint);


            // Draw the HUD
            if(DEBUGGING){
                printDebuggingText();
            }


            // Display the drawing on screen
            // unlockCanvasAndPost is a method of SurfaceHolder
            mOurHolder.unlockCanvasAndPost(mCanvas);
        }

    }

    private void printDebuggingText(){
        int debugSize = mFontSize / 2;
        int debugStart = 150;
        mPaint.setTextSize(debugSize);
        mCanvas.drawText("FPS: " + mFPS ,
                10, debugStart + debugSize, mPaint);

        // We will add more code here in the next chapter
        mCanvas.drawText("Systems: " + mNextSystem,
                10, mFontMargin + debugStart + debugSize * 2, mPaint);

        mCanvas.drawText("Particles: " + mNextSystem * mParticlesPerSystem,
                10, mFontMargin + debugStart + debugSize * 3, mPaint);


    }

    // This method is called by LiveDrawingActivity
// when the user quits the app
    public void pause() {

        // Set mDrawing to false
        // Stopping the thread isn't
        // always instant
        mDrawing = false;
        try {
            // Stop the thread
            mThread.join();
        } catch (InterruptedException e) {
            Log.e("Error:", "joining thread");
        }

    }


    // This method is called by LiveDrawingActivity
    // when the player starts the app
    public void resume() {
        mDrawing = true;
        // Initialize the instance of Thread
        mThread = new Thread(this);

        // Start the thread
        mThread.start();
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        // User moved a finger while touching screen
        if ((motionEvent.getAction() &
                MotionEvent.ACTION_MASK)
                == MotionEvent.ACTION_MOVE) {

            mParticleSystems.get(mNextSystem).emitParticles(
                    new PointF(motionEvent.getX(),
                            motionEvent.getY()));

            mNextSystem++;
            if (mNextSystem == MAX_SYSTEMS) {
                mNextSystem = 0;
            }
        }

        // Did the user touch the screen
        if ((motionEvent.getAction() &
                MotionEvent.ACTION_MASK)
                == MotionEvent.ACTION_DOWN) {

            // User pressed the screen see if it was in a button
            if (mResetButton.contains(motionEvent.getX(),
                    motionEvent.getY())) {
                // Clear the screen of all particles
                mNextSystem = 0;
            }

            // User pressed the screen see if it was in a button
            if (mTogglePauseButton.contains(motionEvent.getX(),
                    motionEvent.getY())) {
                mPaused = !mPaused;
            }
        }


        return true;
    }


}






