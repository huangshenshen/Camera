package com.cninter.com;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

//使用加速度实现摇一摇功能
public class SensorAcitivity extends AppCompatActivity {
    SensorManager sensorManager;
    Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_acitivity);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);

    }

    @Override
    protected void onResume() {
        super.onResume();
        //sensorManager.registerListener(sensorEventListener,sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),sensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(sensorEventListener,sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    protected void onPause() {
        super.onPause();
        //sensorManager.unregisterListener(sensorEventListener,sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER));
        sensorManager.unregisterListener(sensorEventListener,sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER));

    }
    SensorEventListener sensorEventListener = new SensorEventListener() {
       //当传感器执行的时候zzzzzzzzzzzzzzzzzzzzz
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            float[] values = sensorEvent.values;
            float x=values[0];
            float y=values[1];
            float z=values[2];
            int midvalue = 19;
            if (Math.abs(x)>midvalue||Math.abs(y)>midvalue||Math.abs(z)>midvalue){
                //发生加速度运动
                vibrator.vibrate(2*1000);
                Log.i("aaa","手机发生了加速度运动");
                //声音 + 动画
            }

        }
        //当传感器进度发生的时候
        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }
    };

}
