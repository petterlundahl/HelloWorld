package com.petterdoesitbetter.killerBall;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path.Direction;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.view.View;

public class KillerBallView extends View implements SensorEventListener{
	
	private Bitmap floor;
	private Bitmap ball;
	
	private int x;
	private int y;
	private float vx = 0;
	private float vy = 0;
	private float ax = 0;
	private float ay = 0;
	
	public KillerBallView(Context context) {
		super(context);
		
		floor = BitmapFactory.decodeResource(getResources(), R.drawable.floor);
		ball = BitmapFactory.decodeResource(getResources(), R.drawable.icon);
		
	}
	@Override
	protected void onDraw(Canvas canvas)
	{
		vy += ay;
		vx += ax;
		x += vx;
		y += vy;
		
		
		if(x < -20){
			x = -20;
		}
		if(x > 270){
			x = 270;
		}
		if(y < -20){
			y = -20;
		}
		if(y > 430){
			y = 430;
		}
		
		
		canvas.drawBitmap(floor, 0, 0, null);
		canvas.drawBitmap(ball, x, y, null);
		invalidate();
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		// TODO Auto-generated method stub
		
		ax = - event.values[0] / 7;
		ay = event.values[1] / 7;
	}

}
