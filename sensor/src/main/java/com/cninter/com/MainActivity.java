package com.cninter.com;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    SensorManager sensorManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        //传感器的管理者
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> sensors = sensorManager.getSensorList(Sensor.TYPE_ALL);
        //保存所有传感器的名字
        List<String> sensorName= new ArrayList<>();
        for (Sensor sensor:sensors){
            switch (sensor.getType()){
                case Sensor.TYPE_LIGHT:
                    sensorName.add("光感传感器");
                    break;
                case Sensor.TYPE_ACCELEROMETER:
                    sensorName.add("重力加速度传感器");
                    break;
                case Sensor.TYPE_AMBIENT_TEMPERATURE:
                    sensorName.add("温度传感器");
                    break;
                case Sensor.TYPE_ORIENTATION:
                    sensorName.add("方向传感器");
                    break;
            }

        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,sensorName);
        listView.setAdapter(adapter);
        Log.i("aaa","传感器有"+sensors.size());


    }
}
