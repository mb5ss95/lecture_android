/*package com.example.lec7_3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.view.View;

class MyGraphicView extends View {

    static float scaleX, scaleY;
    static float color;
    static float satur;

    public MyGraphicView(Context context) {
        super(context);

        // float scaleX, float scaleY, float color
        //this.scaleX = scaleX;
        //this.scaleY = scaleY;
        //this.color = color;
    }

    @Override
    protected  void onDraw(Canvas canvas){
        super.onDraw(canvas);

        int cenX = this.getWidth()/2;
        int cenY = this.getHeight()/2;
        canvas.scale(scaleX, scaleY);

        Paint paint = new Paint();
        float[] array = {
                color, 0, 0, 0, 0,
                0, color, 0, 0, 0,
                0, 0, color, 0, 0,
                0, 0, 0, 1, 0,
        };

        ColorMatrix cm = new ColorMatrix(array);

        if(satur == 0){
            cm.setSaturation(satur);
        }

        paint.setColorFilter(new ColorMatrixColorFilter(cm));

        Bitmap pic = BitmapFactory.decodeResource(getResources(), R.drawable.nako8);

        int picX = (this.getWidth() - pic.getWidth())/2;
        int picY = (this.getHeight() - pic.getHeight())/2;

        canvas.drawBitmap(pic, picX, picY, paint);

        pic.recycle();
    }
}*/
