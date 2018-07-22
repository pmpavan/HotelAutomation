package com.pmpavan.hotel.builder;

import com.pmpavan.AppConstants;
import com.pmpavan.corridor.main.MainCorridor;
import com.pmpavan.corridor.sub.SubCorridor;
import com.pmpavan.floor.Floor;
import com.pmpavan.floor.FloorBuilder;
import com.pmpavan.floor.FloorBuilderImpl;
import com.pmpavan.floor.FloorManager;
import com.pmpavan.hotel.*;
import com.pmpavan.sensor.Sensor;
import com.pmpavan.sensor.SensorListener;

import java.util.ArrayList;
import java.util.HashMap;

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
        FloorBuilder floor = new FloorBuilderImpl();
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
    public Floor getFloorAtPosition(int position) {
        return hotel.getFloors().get(position);
    }

    @Override
    public MainCorridor getMainCorridor(int floorNumber, int mainCorridorNumber) {
        FloorManager floorManager = new FloorManager();
        Floor floor = getFloorAtPosition(floorNumber);
        return floorManager.getMainCorridor(floor, mainCorridorNumber);
    }

    @Override
    public SubCorridor getSubCorridor(int floorNumber, int subCorridorNumber) {
        FloorManager floorManager = new FloorManager();
        Floor floor = getFloorAtPosition(floorNumber);
        return floorManager.getSubCorridor(floor, subCorridorNumber);
    }

    @Override
    public ArrayList<SubCorridor> getSubCorridors(int floorNumber) {
        FloorManager floorManager = new FloorManager();
        Floor floor = getFloorAtPosition(floorNumber);
        return floorManager.getSubCorridors(floor);
    }

    @Override
    public String toString() {
        return hotel != null ? hotel.toString() : "";
    }
}
