package com.pmpavan.corridor.sub;

import com.pmpavan.AppConstants;
import com.pmpavan.sensor.Sensor;
import com.pmpavan.sensor.SensorListener;

import java.util.HashMap;

public interface SubCorridorBuilder {
    SubCorridor createCorridor(int floorNumber, int subCorridorNumber, HashMap<AppConstants.APPLIANCES, Integer> appliancesInSubCorridor,
                               HashMap<String, Sensor> sensorMap, SensorListener listener);
}
