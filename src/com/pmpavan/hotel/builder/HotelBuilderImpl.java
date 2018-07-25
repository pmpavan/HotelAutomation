package com.pmpavan.hotel.builder;

import com.pmpavan.AppConstants;
import com.pmpavan.corridor.main.MainCorridor;
import com.pmpavan.corridor.sub.SubCorridor;
import com.pmpavan.floor.Floor;
import com.pmpavan.floor.FloorBuilder;
import com.pmpavan.floor.FloorBuilderImpl;
import com.pmpavan.floor.FloorManager;
import com.pmpavan.hotel.Hotel;
import com.pmpavan.sensor.Sensor;
import com.pmpavan.sensor.SensorListener;
import javafx.util.Pair;

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
    public ArrayList<MainCorridor> getMainCorridors(int floorNumber) {
        FloorManager floorManager = new FloorManager();
        Floor floor = getFloorAtPosition(floorNumber);
        return floorManager.getMainCorridors(floor);
    }

    @Override
    public ArrayList<Floor> getFloors() {
        return hotel.getFloors();
    }

    @Override
    public String toString() {
        return hotel != null ? hotel.toString() : "";
    }


    @Override
    public double getPowerConsumed() {
        double powerConsumedByMainCorridor = 0, powerConsumedBySubCorridor = 0;
        for (Floor floor : hotel.getFloors()) {
            FloorBuilder floorBuilder = new FloorBuilderImpl(floor);
            Pair<Double, Double> pair = floorBuilder.getPowerConsumed();
            powerConsumedByMainCorridor += pair.getKey();
            powerConsumedBySubCorridor += pair.getValue();
        }
        return powerConsumedByMainCorridor + powerConsumedBySubCorridor;
    }

    @Override
    public Pair<Double, Double> getMaxPowerConsumed() {
        double powerConsumedByMainCorridor = 0, powerConsumedBySubCorridor = 0;
        for (Floor floor : hotel.getFloors()) {
            FloorBuilder floorBuilder = new FloorBuilderImpl(floor);
            Pair<Double, Double> pair = floorBuilder.getPowerConsumed();
            powerConsumedByMainCorridor += pair.getKey();
            powerConsumedBySubCorridor += pair.getValue();
        }
        return new Pair<>((powerConsumedByMainCorridor * 15) , (powerConsumedBySubCorridor * 10));
    }

}
