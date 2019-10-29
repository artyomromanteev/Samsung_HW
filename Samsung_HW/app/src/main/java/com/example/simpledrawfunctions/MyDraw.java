package com.example.simpledrawfunctions;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class MyDraw extends View {

    int N = 50;
    float[] x  = new float[N];
    float[] y  = new float[N];
    float[] vx = new float[N];
    float[] vy = new float[N];

    float rand (float min, float max){
        return(float)(Math.random() * (max - min + 1)) + min;
    }

    void fillRandom(float[] array , float min, float max){
        for (int i = 0; i < array.length; i++){
            array[i] = rand (min, max);
        }
    }

    public MyDraw(Context context) {
        super(context);
        fillRandom(x, 0, 500);
        fillRandom(y, 0, 500);
        fillRandom(vx, -3, 3);
        fillRandom(vy, -3, 3);
    }

    void add(float[] array , float[] values){
        for (int i = 0; i < array.length; i++){
            array[i] += values[i];
        }

    }

    Paint paint = new Paint();

    void drawBalls(Canvas canvas){
        for(int i = 0; i < N; i++){
            canvas.drawCircle(x[i], y[i], 50, paint);
        }
    }
    
    void check(){
        for (int i = 0; i < vx.length; i++){
            if(x[i] < 0 || x[i]  > getWidth()){
                vx[i] = - vx[i];
            }else if(y[i] < 0 || y[i]  > getHeight()){
                vy[i] = - vy[i];
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        drawBalls(canvas);
        add(x, vx);
        add(y, vy);
        check();
        invalidate();
    }

}