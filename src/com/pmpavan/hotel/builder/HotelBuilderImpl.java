package com.pmpavan.hotel.builder;

import com.pmpavan.AppConstants;
import com.pmpavan.AppUtils;
import com.pmpavan.corridor.MainCorridor;
import com.pmpavan.corridor.SubCorridor;
import com.pmpavan.electricals.AC;
import com.pmpavan.electricals.Appliance;
import com.pmpavan.electricals.TubeLight;
import com.pmpavan.floor.Floor;
import com.pmpavan.floor.FloorBuilderImpl;
import com.pmpavan.hotel.*;
import com.pmpavan.sensor.MotionSensor;
import com.pmpavan.sensor.Sensor;
import com.pmpavan.sensor.SensorListener;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HotelBuilderImpl implements HotelBuilder {


    private Hotel hotel;

    public HotelBuilderImpl() {
        hotel = new Hotel();
    }

    private HotelBuilderImpl setStructure(int numberOfFloors,
                                          int numberOfMainCorridors, HashMap<AppConstants.APPLIANCES, Integer> appliancesInMainCorridor,
                                          int numberOfSubCorridors, HashMap<AppConstants.APPLIANCES, Integer> appliancesInSubCorridor,
                                          HashMap<String, Sensor> sensorMap, SensorListener listener) {
        ArrayList<Floor> floors = new ArrayList<>();
        for (int floorNumber = 0; floorNumber < numberOfFloors; floorNumber++) {
            Floor floor = createFloor(floorNumber, numberOfMainCorridors, appliancesInMainCorridor, numberOfSubCorridors, appliancesInSubCorridor, sensorMap, listener);
            floors.add(floor);
        }
        hotel.setFloors(floors);
        return this;
    }

    private Floor createFloor(int floorNumber, int numberOfMainCorridors, HashMap<AppConstants.APPLIANCES, Integer> appliancesInMainCorridor,
                              int numberOfSubCorridors, HashMap<AppConstants.APPLIANCES, Integer> appliancesInSubCorridor,
                              HashMap<String, Sensor> sensorMap, SensorListener listener) {
        FloorBuilderImpl floor = new FloorBuilderImpl();
        return floor.createFloor(floorNumber, numberOfMainCorridors, appliancesInMainCorridor, numberOfSubCorridors, appliancesInSubCorridor, sensorMap, listener);
    }


    @Override
    public void initHotelState(int numberOfFloors,
                               int numberOfMainCorridors, HashMap<AppConstants.APPLIANCES, Integer> appliancesInMainCorridor,
                               int numberOfSubCorridors, HashMap<AppConstants.APPLIANCES, Integer> appliancesInSubCorridor,
                               HashMap<String, Sensor> sensorMap, SensorListener listener) {
        setStructure(numberOfFloors,
                numberOfMainCorridors, appliancesInMainCorridor,
                numberOfSubCorridors, appliancesInSubCorridor,
                sensorMap, listener);
    }

    @Override
    public String toString() {
        return hotel != null ? hotel.toString() : "";
    }
}
