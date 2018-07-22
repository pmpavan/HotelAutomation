package com.pmpavan.hotel.builder;

import com.pmpavan.AppConstants;
import com.pmpavan.AppUtils;
import com.pmpavan.electricals.AC;
import com.pmpavan.electricals.Appliance;
import com.pmpavan.electricals.TubeLight;
import com.pmpavan.hotel.Floor;
import com.pmpavan.hotel.Hotel;
import com.pmpavan.hotel.MainCorridor;
import com.pmpavan.hotel.SubCorridor;
import com.pmpavan.sensor.Sensor;
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
                                          HashMap<Integer, Sensor> sensorMap) {
        ArrayList<Floor> floors = new ArrayList<>();
        for (int i = 0; i < numberOfFloors; i++) {
            Floor floor = createFloor(i, numberOfMainCorridors, appliancesInMainCorridor, numberOfSubCorridors, appliancesInSubCorridor, sensorMap);
            floors.add(floor);
        }
        hotel.setFloors(floors);
        return this;
    }

    private Floor createFloor(int floorNumber, int numberOfMainCorridors, HashMap<AppConstants.APPLIANCES, Integer> appliancesInMainCorridor,
                              int numberOfSubCorridors, HashMap<AppConstants.APPLIANCES, Integer> appliancesInSubCorridor,
                              HashMap<Integer, Sensor> sensorMap) {
        Floor floor = new Floor();
        floor.setFloorNumber(floorNumber);
        Pair<ArrayList<MainCorridor>, ArrayList<SubCorridor>> pair = createCorridors(numberOfMainCorridors, appliancesInMainCorridor, numberOfSubCorridors, appliancesInSubCorridor, sensorMap);
        ArrayList<MainCorridor> mainCorridors = pair.getKey();
        ArrayList<SubCorridor> subCorridors = pair.getValue();
        floor.setMainCorridors(mainCorridors);
        floor.setSubCorridors(subCorridors);
        return floor;
    }

    private Pair<ArrayList<MainCorridor>, ArrayList<SubCorridor>> createCorridors(int numberOfMainCorridors,
                                                                                  HashMap<AppConstants.APPLIANCES, Integer> appliancesInMainCorridor,
                                                                                  int numberOfSubCorridors,
                                                                                  HashMap<AppConstants.APPLIANCES, Integer> appliancesInSubCorridor,
                                                                                  HashMap<Integer, Sensor> sensorMap) {
        ArrayList<MainCorridor> mainCorridors = new ArrayList<>();
        ArrayList<SubCorridor> subCorridors = new ArrayList<>();
        for (int j = 0; j < numberOfMainCorridors; j++) {
            MainCorridor mainCorridor = createMainCorridor(appliancesInMainCorridor, sensorMap);
            mainCorridors.add(mainCorridor);
        }
        for (int k = 0; k < numberOfSubCorridors; k++) {
            SubCorridor subCorridor = createSubCorridor(appliancesInSubCorridor, sensorMap);
            subCorridors.add(subCorridor);
        }
        return new Pair<>(mainCorridors, subCorridors);
    }

    private MainCorridor createMainCorridor(HashMap<AppConstants.APPLIANCES, Integer> appliancesInMainCorridor, HashMap<Integer, Sensor> sensorMap) {
        MainCorridor mainCorridor = new MainCorridor();
        ArrayList<Appliance> appliances = getAppliances(appliancesInMainCorridor);
        mainCorridor.setAppliances(appliances);
        mainCorridor.setSensorId(AppUtils.getSensorUniqueId());
        return mainCorridor;
    }

    private SubCorridor createSubCorridor(HashMap<AppConstants.APPLIANCES, Integer> appliancesInSubCorridor, HashMap<Integer, Sensor> sensorMap) {
        SubCorridor subCorridor = new SubCorridor();
        ArrayList<Appliance> appliances = getAppliances(appliancesInSubCorridor);
        subCorridor.setAppliances(appliances);
        return subCorridor;
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
                               int numberOfSubCorridors, HashMap<AppConstants.APPLIANCES, Integer> appliancesInSubCorridor, HashMap<Integer, Sensor> sensorMap) {
        setStructure(numberOfFloors,
                numberOfMainCorridors, appliancesInMainCorridor,
                numberOfSubCorridors, appliancesInSubCorridor, sensorMap);
    }

    @Override
    public String toString() {
        return hotel != null ? hotel.toString() : "";
    }
}
