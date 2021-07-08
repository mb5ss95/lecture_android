package com.example.lec7_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(new MyGraphicView(this));
    }

    private static class MyGraphicView extends View {

        public MyGraphicView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            Bitmap pic = BitmapFactory.decodeResource(getResources(), R.drawable.nako1);
            pic = Bitmap.createScaledBitmap(pic, 540, 792, true);
            int picX = (this.getWidth() - pic.getWidth()) / 2;
            int picY = (this.getHeight() - pic.getHeight()) / 2;
            System.out.println("testxxxxx" + this.getWidth() + pic.getWidth());
            System.out.println("testyyyyy" + this.getHeight() + pic.getHeight());
            Paint paint = new Paint();
            //canvas.scale((float) 0.2, (float) 0.2, this.getWidth() / 2, this.getHeight() / 2);

            float[] array = {
                    1, 0, 0, 0, 25,
                    0, 1, 0, 0, 25,
                    0, 0, 1, 0, 25,
                    0, 0, 0, 1, 0
            };
            float[] IDENTITY = {
                    1, 0, 0, 0, 0,
                    0, 1, 0, 0, 0,
                    0, 0, 1, 0, 0,
                    0, 0, 0, 1, 0
            };
            float[] INVERT = {
                    -1, 0, 0, 0, 255,
                    0, -1, 0, 0, 255,
                    0, 0, -1, 0, 255,
                    0, 0, 0, 1, 0
            };
            float[] REDONLY = {
                    1, 0, 0, 0, 0,
                    0, 0, 0, 0, 0,
                    0, 0, 0, 0, 0,
                    0, 0, 0, 1, 0
            };
            float[] GREENONLY = {
                    0, 0, 0, 0, 0,
                    0, 1, 0, 0, 0,
                    0, 0, 0, 0, 0,
                    0, 0, 0, 1, 0
            };
            float[] BLUEONLY = {
                    0, 0, 0, 0, 0,
                    0, 0, 0, 0, 0,
                    0, 0, 1, 0, 0,
                    0, 0, 0, 1, 0
            };
            float[] SWAP_R_G = {
                    0, 1, 0, 0, 0,
                    1, 0, 0, 0, 0,
                    0, 0, 1, 0, 0,
                    0, 0, 0, 1, 0
            };
            float[] SWAP_R_B = {
                    0, 0, 1, 0, 0,
                    0, 1, 0, 0, 0,
                    1, 0, 0, 0, 0,
                    0, 0, 0, 1, 0
            };
            float[] SWAP_G_B = {
                    1, 0, 0, 0, 0,
                    0, 0, 1, 0, 0,
                    0, 1, 0, 0, 0,
                    0, 0, 0, 1, 0
            };
            float[] GRAYSCALE = {
                    0.2989f, 0.5870f, 0.1140f, 0, 0,
                    0.2989f, 0.5870f, 0.1140f, 0, 0,
                    0.2989f, 0.5870f, 0.1140f, 0, 0,
                    0.0000F, 0.0000F, 0.0000F, 1, 0
            };
            float[] SEPIA = {
                    0.393F, 0.769F, 0.189F, 0, 0,
                    0.349F, 0.686F, 0.168F, 0, 0,
                    0.272F, 0.534F, 0.131F, 0, 0,
                    0.000F, 0.000F, 0.000F, 1, 0
            };

            // warm 5000K 1.0000 0.7992 0.6045
            float[] WARM = {
                    1.000F, 0.000F, 0.000F, 0, 0,
                    0.000F, 0.780F, 0.000F, 0, 0,
                    0.000F, 0.000F, 0.605F, 0, 0,
                    0.000F, 0.000F, 0.000F, 1, 0
            };

            // cool 8000K 0.7644 0.8139 1.0000
           float[] COOL = {
                   0.765F, 0.000F, 0.000F, 0, 0,
                   0.000F, 0.814F, 0.000F, 0, 0,
                   0.000F, 0.000F, 1.000f, 0, 0,
                   0.000F, 0.000F, 0.000F, 1, 0
           };


            //ColorMatrix cm = new ColorMatrix(GRAYSCALE);
            ColorMatrix cm = new ColorMatrix(array);
            //cm.postConcat(new ColorMatrix(GRAYSCALE));
            paint.setColorFilter(new ColorMatrixColorFilter(cm));
            canvas.drawBitmap(pic, picX, picY, paint);
            pic.recycle();

        }
    }
}
