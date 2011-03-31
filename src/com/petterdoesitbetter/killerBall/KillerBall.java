package com.petterdoesitbetter.killerBall;


import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class KillerBall extends Activity {
    
	private KillerBallView killerBallView;
	private SensorManager sensorManager;
    private Sensor sensor;
    
    //Petter does it better fo' sho'!!!
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        killerBallView = new KillerBallView(this);
        setContentView(killerBallView);
        
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(killerBallView, sensor, SensorManager.SENSOR_DELAY_UI);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.one:     Toast.makeText(this, "You selected green!", Toast.LENGTH_LONG).show();
                                break;
            case R.id.two:     Toast.makeText(this, "You selected red!", Toast.LENGTH_LONG).show();
                                break;
            case R.id.three: Toast.makeText(this, "You selected blue!", Toast.LENGTH_LONG).show();
                                break;
        }
        return true;
    }
    
}