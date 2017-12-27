package com.example.milde.motionssensorproject;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener{
    private SensorManager sensorManager;
    private Sensor sensor;
    private TextView tvSensorXVal, tvSensorYVal, tvSensorZVal;

    @Override
    protected void onResume() {
        super.onResume();

        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, sensor,
                SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        tvSensorXVal = (TextView)findViewById(R.id.tvSensorXVal);
        tvSensorYVal = (TextView)findViewById(R.id.tvSensorYVal);
        tvSensorZVal = (TextView)findViewById(R.id.tvSensorZVal);


    }

    private void rausDamit(String s) {
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float[] values = sensorEvent.values;
        // Movement
        float x = values[0];
        float y = values[1];
        float z = values[2];

        tvSensorXVal.setText("X: " + x);
        tvSensorYVal.setText("Y: " + y);
        tvSensorZVal.setText("Z: " + z);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
