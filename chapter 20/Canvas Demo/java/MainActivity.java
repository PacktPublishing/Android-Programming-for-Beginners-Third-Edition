package com.gamecodeschool.canvasdemo;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends Activity {

    // Here are all the objects(instances)
    // of classes that we need to do some drawing
    ImageView myImageView;
    Bitmap myBlankBitmap;
    Canvas myCanvas;
    Paint myPaint;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize all the objects ready for drawing
        // We will do this inside the onCreate method
        int widthInPixels = 800;
        int heightInPixels = 600;

        // Create a new Bitmap
        myBlankBitmap = Bitmap.createBitmap(widthInPixels,
                heightInPixels,
                Bitmap.Config.ARGB_8888);

        // Initialize the Canvas and associate it
        // with the Bitmap to draw on
        myCanvas = new Canvas(myBlankBitmap);

        // Initialize the ImageView and the Paint
        myImageView = new ImageView(this);
        myPaint = new Paint();

        // Draw on the Bitmap
        // Wipe the Bitmap with a blue color
        myCanvas.drawColor(Color.argb(255, 0, 0, 255));

        // Re-size the text
        myPaint.setTextSize(100);
        // Change the paint to white
        myPaint.setColor(Color.argb(255, 255, 255, 255));
        // Draw some text
        myCanvas.drawText("Hello World!",100, 100, myPaint);

        // Change the paint to yellow
        myPaint.setColor(Color.argb(255, 212, 207, 62));
        // Draw a circle
        myCanvas.drawCircle(400,250, 100, myPaint);
        // Associate the drawn upon Bitmap with the ImageView
        myImageView.setImageBitmap(myBlankBitmap);
        // Tell Android to set our drawing
        // as the view for this app
        // via the ImageView
        setContentView(myImageView);

    }
}
