package com.pmpavan.floor;

import com.pmpavan.AppConstants;
import com.pmpavan.sensor.Sensor;
import com.pmpavan.sensor.SensorListener;
import javafx.util.Pair;

import java.util.HashMap;

public interface FloorBuilder {

    Floor createFloor(int floorNumber, int numberOfMainCorridors, HashMap<AppConstants.APPLIANCES, Integer> appliancesInMainCorridor, int numberOfSubCorridors, HashMap<AppConstants.APPLIANCES, Integer> appliancesInSubCorridor, HashMap<String, Sensor> sensorMap, SensorListener listener);

    Pair<Double, Double> getPowerConsumed();
}
