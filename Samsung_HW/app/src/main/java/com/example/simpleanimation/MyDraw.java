package com.example.simpleanimation;

import android.content.Context;
import android.graphics.*;
import android.view.View;

public class MyDraw extends View {
    Paint paint = new Paint();
    long lastTime = System.currentTimeMillis();
    float x = 0;

    MyDraw(Context context) {

        super(context);

    }

    @Override

    protected void onDraw(Canvas canvas) {
        int N = 15, count = 0;
        float[] x = new float[N];
        float[] y = new float[N];
        float[] vx = new float[N];
        float[] vy = new float[N];
        for(int i = 0; i < N; i++){
            x[i] = (float)(Math.random() * getWidth());
            y[i] = (float)(Math.random() * getHeight());
            vx[i] = (float)(Math.random() * 0.1);
            vy[i] = (float)(Math.random() * 0.1);
        }
        setBackgroundColor(Color.BLACK);
        for(int i = 0; i < N; i++){
            if(i % 2 != 0){
                paint.setColor(Color.YELLOW);
                canvas.drawCircle(x[i], y[i], 50, paint);
            } else {
                paint.setColor(Color.BLUE);
                canvas.drawCircle(x[i], y[i], 35, paint);
            }
        }
        for(int i = 0; i < N; i++){
            x[i] += vx[i];
            y[i] += vy[i];

        }
        for(int i = 0; i < N; i++){
            if(x[i] < 0 || x[i] > getHeight()){
                vx[i] = - vx[i];
            }else if(y[i] < 0 || y[i] > getWidth()){
                vy[i] = - vy[i];
            }
        }

        invalidate();
    }
}
