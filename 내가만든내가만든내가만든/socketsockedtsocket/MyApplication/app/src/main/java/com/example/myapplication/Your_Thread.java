package com.example.myapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

class Your_Thread implements Runnable {

    byte[] bytes;
    ImageView img;

    Your_Thread(byte[] bytes, ImageView img) {
        this.bytes = bytes;
        this.img = img;
    }

    public void run() {
        Bitmap bm = BitmapFactory.decodeByteArray(bytes, 0, bytes.length) ;
        img.setImageBitmap(bm) ;
    }
}
