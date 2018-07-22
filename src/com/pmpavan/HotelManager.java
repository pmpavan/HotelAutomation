package com.pmpavan;

import com.pmpavan.hotel.builder.HotelBuilder;
import com.pmpavan.hotel.builder.HotelBuilderImpl;
import com.pmpavan.sensor.Sensor;
import com.pmpavan.sensor.SensorListener;

import java.util.HashMap;
import java.util.Map;

public class HotelManager implements SensorListener {


    private HotelBuilder hotel;
    private HashMap<String, Sensor> sensorMap = new HashMap<>();

    public HotelManager(int numberOfFloors,
                        int numberOfMainCorridors, HashMap<AppConstants.APPLIANCES, Integer> appliancesInMainCorridor,
                        int numberOfSubCorridors, HashMap<AppConstants.APPLIANCES, Integer> appliancesInSubCorridor) {
        hotel = new HotelBuilderImpl();
        hotel.initHotelState(
                numberOfFloors,
                numberOfMainCorridors,
                appliancesInMainCorridor,
                numberOfSubCorridors,
                appliancesInSubCorridor,
                sensorMap, this);
    }


    public void setSensorData(int floorNumber, int corridorNumber, boolean isMainCorridor) {
        for (Map.Entry<String, Sensor> entry : sensorMap.entrySet()) {
            System.out.println("entry " + entry.getKey() + " " + entry.getValue());
        }

        String sensorId = AppUtils.getSensorUniqueId(floorNumber, corridorNumber, isMainCorridor);
        Sensor sensor = sensorMap.get(sensorId);
        System.out.println("sensor " + sensorId);
        sensor.setDetected(true);
    }

    String getCurrentHotelState() {
        return hotel != null ? hotel.toString() : "";
    }

    @Override
    public void onSensorDetected(Sensor sensor) {
        System.out.println("Sensor value changed at " + sensor.getSensorId());
    }
}
