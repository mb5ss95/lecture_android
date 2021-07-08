package com.example.lec7_3;

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
import android.widget.ImageButton;
import android.widget.LinearLayout;


public class MainActivity extends AppCompatActivity {


    ImageButton idzoomin, idzoomout, idrotate,
            idbright, iddark, idgray;
    MyGraphicView graphicView;

    static float angle = 0;
    static float color = 1;
    static float satur = 1;
    static float scaleX = 1, scaleY = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("미니 포토샾");

        LinearLayout pictureLayout = findViewById(R.id.piclay);
        graphicView = new MyGraphicView(this);
        //scaleX, scaleY, color
        pictureLayout.addView(graphicView);

        clickIcons();
    }

    private void clickIcons(){

        idzoomin = findViewById(R.id.idzoomin);
        idzoomin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                scaleX = scaleX + 0.2f;
                scaleY = scaleY + 0.2f;
                graphicView.invalidate();
            }
        });


        idzoomout = findViewById(R.id.idzoomout);
        idzoomout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                scaleX = scaleX - 0.2f;
                scaleY = scaleY - 0.2f;
                graphicView.invalidate();
            }
        });

        idrotate = findViewById(R.id.idrotate);
        idrotate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                angle = angle + 20;
                graphicView.invalidate();
            }
        });

        idbright = findViewById(R.id.idbright);
        idbright.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                color = color + 0.2f;
                graphicView.invalidate();
            }
        });

        iddark = findViewById(R.id.iddark);
        iddark.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                color = color - 0.2f;
                graphicView.invalidate();
            }
        });

        idgray = findViewById(R.id.idgray);
        idgray.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(satur == 0){
                    satur = 1;
                }
                else{
                    satur = 0;
                }
                graphicView.invalidate();
            }
        });
    }

    class MyGraphicView extends View {

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
    }

}
