package com.pmpavan.hotel.builder;

import com.pmpavan.AppConstants;
import com.pmpavan.sensor.Sensor;
import com.pmpavan.sensor.SensorListener;

import java.util.HashMap;

public interface HotelBuilder {

    void initHotelState(int numberOfFloors,
                        int numberOfMainCorridors, HashMap<AppConstants.APPLIANCES, Integer> appliancesInMainCorridor,
                        int numberOfSubCorridors, HashMap<AppConstants.APPLIANCES, Integer> appliancesInSubCorridor,
                        HashMap<String, Sensor> sensorMap, SensorListener listener);

}
