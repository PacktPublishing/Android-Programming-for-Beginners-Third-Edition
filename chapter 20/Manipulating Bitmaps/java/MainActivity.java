package com.gamecodeschool.manipulatingbitmaps;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends Activity {

    // Here are all the objects(instances)
    // of classes that we need to do some drawing
    ImageView myImageView;
    Bitmap myBlankBitmap;
    Bitmap bobBitmap;
    Canvas myCanvas;
    Paint myPaint;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Initialize all the objects ready for drawing
        int widthInPixels = 2000;
        int heightInPixels = 1000;

        // Create a new Bitmap
        myBlankBitmap = Bitmap.createBitmap(widthInPixels,
                heightInPixels,
                Bitmap.Config.ARGB_8888);

        // Initialize Bob
        bobBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bob);

        // Initialize the Canvas and associate it
        // with the Bitmap to draw on
        myCanvas = new Canvas(myBlankBitmap);

        // Initialize the ImageView and the Paint
        myImageView = new ImageView(this);
        myPaint = new Paint();

        // Draw on the Bitmap
        // Wipe the Bitmap with a blue color
        myCanvas.drawColor(Color.argb(255, 0, 0, 255));

        // Draw some bitmaps
        drawRotatedBitmaps();
        drawEnlargedBitmap();
        drawShrunkenBitmap();

        // Associate the drawn upon Bitmap with the ImageView
        myImageView.setImageBitmap(myBlankBitmap);
        // Tell Android to set our drawing
        // as the view for this app
        // via the ImageView
        setContentView(myImageView);


    }

    void drawRotatedBitmaps(){
        float rotation = 0f;
        int horizontalPosition =350;
        int verticalPosition = 25;
        Matrix matrix = new Matrix();

        Bitmap rotatedBitmap = Bitmap.createBitmap(100,
                200,
                Bitmap.Config.ARGB_8888);

        for(rotation = 0; rotation < 360; rotation += 30){
            matrix.reset();
            matrix.preRotate(rotation);
            rotatedBitmap = Bitmap
                    .createBitmap(bobBitmap,
                            0, 0, bobBitmap.getWidth()-1,
                            bobBitmap.getHeight()-1,
                            matrix, true);

            myCanvas.drawBitmap(rotatedBitmap,
                    horizontalPosition,
                    verticalPosition,
                    myPaint);

            horizontalPosition += 120;
            verticalPosition += 70;
        }
    }

    void drawEnlargedBitmap(){
        bobBitmap = Bitmap
                .createScaledBitmap(bobBitmap,
                        300, 400, false);
        myCanvas.drawBitmap(bobBitmap, 25,25, myPaint);

    }

    void drawShrunkenBitmap(){
        bobBitmap = Bitmap
                .createScaledBitmap(bobBitmap,
                        50, 75, false);
        myCanvas.drawBitmap(bobBitmap, 250,25, myPaint);
    }


}