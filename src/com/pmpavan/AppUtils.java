package com.pmpavan;

import com.pmpavan.sensor.MotionSensor;
import com.pmpavan.sensor.Sensor;
import com.pmpavan.sensor.SensorListener;

import java.util.HashMap;

public class AppUtils {
    public static String getSensorUniqueId(int floorNumber, int corridorNumber, boolean isMainCorridor) {
        StringBuilder builder = new StringBuilder("F");
        builder.append(floorNumber);
        if (isMainCorridor)
            builder.append("M");
        else
            builder.append("S");
        builder.append(corridorNumber);
        return builder.toString();
    }

    public static String putInSensorMap(int floorNumber, int corridorNumber, boolean isMainCorridor, HashMap<String, Sensor> sensorMap, SensorListener listener) {
        String sensorId = AppUtils.getSensorUniqueId(floorNumber, corridorNumber, isMainCorridor);
        Sensor sensor = new MotionSensor(sensorId, floorNumber, corridorNumber, isMainCorridor, listener);
        sensorMap.put(sensorId, sensor);
        return sensorId;
    }
}
