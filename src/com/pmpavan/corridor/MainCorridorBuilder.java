package com.pmpavan.corridor;

import com.pmpavan.AppConstants;
import com.pmpavan.sensor.Sensor;
import com.pmpavan.sensor.SensorListener;

import java.util.HashMap;

public interface MainCorridorBuilder {
    MainCorridor createCorridor(int floorNumber, int mainCorridorId, HashMap<AppConstants.APPLIANCES, Integer> appliancesInMainCorridor, HashMap<String, Sensor> sensorMap, SensorListener listener);
}
