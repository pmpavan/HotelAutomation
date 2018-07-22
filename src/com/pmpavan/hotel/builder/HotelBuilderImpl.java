package com.pmpavan.hotel.builder;

import com.pmpavan.AppConstants;
import com.pmpavan.AppUtils;
import com.pmpavan.electricals.AC;
import com.pmpavan.electricals.Appliance;
import com.pmpavan.electricals.TubeLight;
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
        Floor floor = new Floor();
        floor.setFloorNumber(floorNumber);
        Pair<ArrayList<MainCorridor>, ArrayList<SubCorridor>> pair = createCorridors(floorNumber, numberOfMainCorridors, appliancesInMainCorridor, numberOfSubCorridors, appliancesInSubCorridor, sensorMap, listener);
        ArrayList<MainCorridor> mainCorridors = pair.getKey();
        ArrayList<SubCorridor> subCorridors = pair.getValue();
        floor.setMainCorridors(mainCorridors);
        floor.setSubCorridors(subCorridors);
        return floor;
    }

    private Pair<ArrayList<MainCorridor>, ArrayList<SubCorridor>> createCorridors(
            int floorNumber, int numberOfMainCorridors,
            HashMap<AppConstants.APPLIANCES, Integer> appliancesInMainCorridor,
            int numberOfSubCorridors,
            HashMap<AppConstants.APPLIANCES, Integer> appliancesInSubCorridor,
            HashMap<String, Sensor> sensorMap, SensorListener listener) {

        ArrayList<MainCorridor> mainCorridors = new ArrayList<>();
        ArrayList<SubCorridor> subCorridors = new ArrayList<>();
        for (int mainCorridorId = 0; mainCorridorId < numberOfMainCorridors; mainCorridorId++) {
            MainCorridor mainCorridor = createMainCorridor(floorNumber, mainCorridorId, appliancesInMainCorridor, sensorMap, listener);
            mainCorridors.add(mainCorridor);
        }
        for (int subCorridorId = 0; subCorridorId < numberOfSubCorridors; subCorridorId++) {
            SubCorridor subCorridor = createSubCorridor(floorNumber, subCorridorId, appliancesInSubCorridor, sensorMap, listener);
            subCorridors.add(subCorridor);
        }
        return new Pair<>(mainCorridors, subCorridors);
    }

    private MainCorridor createMainCorridor(int floorNumber, int mainCorridorNumber, HashMap<AppConstants.APPLIANCES, Integer> appliancesInMainCorridor,
                                            HashMap<String, Sensor> sensorMap, SensorListener listener) {
        MainCorridor mainCorridor = new MainCorridor();
        ArrayList<Appliance> appliances = getAppliances(appliancesInMainCorridor);
        mainCorridor.setAppliances(appliances);

        putInSensorMap(floorNumber, mainCorridorNumber, true, sensorMap, mainCorridor, listener);
        return mainCorridor;
    }

    private SubCorridor createSubCorridor(int floorNumber, int subCorridorNumber, HashMap<AppConstants.APPLIANCES, Integer> appliancesInSubCorridor,
                                          HashMap<String, Sensor> sensorMap, SensorListener listener) {

        SubCorridor subCorridor = new SubCorridor();
        ArrayList<Appliance> appliances = getAppliances(appliancesInSubCorridor);
        subCorridor.setAppliances(appliances);

        putInSensorMap(floorNumber, subCorridorNumber, false, sensorMap, subCorridor, listener);

        return subCorridor;
    }

    private void putInSensorMap(int floorNumber, int corridorNumber, boolean isMainCorridor, HashMap<String, Sensor> sensorMap, Corridor corridor, SensorListener listener) {
        String sensorId = AppUtils.getSensorUniqueId(floorNumber, corridorNumber, isMainCorridor);
        Sensor sensor = new MotionSensor(sensorId, floorNumber, corridorNumber, isMainCorridor, listener);
        sensorMap.put(sensorId, sensor);
        corridor.setSensorId(sensorId);

    }

    private ArrayList<Appliance> getAppliances(HashMap<AppConstants.APPLIANCES, Integer> appliancesInMainCorridor) {
        ArrayList<Appliance> appliances = new ArrayList<>();
        for (Map.Entry<AppConstants.APPLIANCES, Integer> entry : appliancesInMainCorridor.entrySet()) {
            Appliance appliance = null;
            switch (entry.getKey()) {
                case AC:
                    appliance = new AC();
                    break;
                case LIGHT:
                    appliance = new TubeLight();
                    break;
            }
            appliances.add(appliance);
        }
        return appliances;
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
