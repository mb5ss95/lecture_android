package com.example.lec7;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(new MyGraphicView(this));
    }

    private static class MyGraphicView extends View {

        public MyGraphicView(Context context){
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas){
            super.onDraw(canvas);

            Bitmap pic = BitmapFactory.decodeResource(getResources(), R.drawable.nako3);

            int cenX = this.getWidth() / 2;
            int cenY = this.getHeight() / 2;
            int picX = (this.getWidth() - pic.getWidth())/2;
            int picY = (this.getHeight() - pic.getHeight())/2;
            canvas.scale((float)0.2, (float)0.2, cenX, cenY);
            // 1. 회전
            //canvas.rotate(45, cenX, cenY);
            //canvas.drawBitmap(pic, picX, picY, null);
            // 2. 이동
            //canvas.translate(0, 0);
            //canvas.drawBitmap(pic, picX, picY, null);
            // 3. 크기 변환
            //canvas.scale((float)0.2, (float)0.2, cenX, cenY);
            //canvas.drawBitmap(pic, picX, picY, null);
            // 4. 기울이기
            canvas.skew(0.3f, 0.3f);
            canvas.drawBitmap(pic, picX, picY, null);

            pic.recycle();
        }
    }
}
