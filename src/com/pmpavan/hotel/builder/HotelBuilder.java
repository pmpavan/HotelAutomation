package com.pmpavan.hotel.builder;

import com.pmpavan.AppConstants;
import com.pmpavan.corridor.main.MainCorridor;
import com.pmpavan.corridor.sub.SubCorridor;
import com.pmpavan.floor.Floor;
import com.pmpavan.sensor.Sensor;
import com.pmpavan.sensor.SensorListener;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;

public interface HotelBuilder {

    void initHotelState(int numberOfFloors,
                        int numberOfMainCorridors, HashMap<AppConstants.APPLIANCES, Integer> appliancesInMainCorridor,
                        int numberOfSubCorridors, HashMap<AppConstants.APPLIANCES, Integer> appliancesInSubCorridor,
                        HashMap<String, Sensor> sensorMap, SensorListener listener);

    Floor getFloorAtPosition(int position);

    MainCorridor getMainCorridor(int floorNumber, int mainCorridorNumber);

    SubCorridor getSubCorridor(int floorNumber, int subCorridorNumber);

    ArrayList<SubCorridor> getSubCorridors(int floorNumber);

    ArrayList<MainCorridor> getMainCorridors(int floorNumber);

    ArrayList<Floor> getFloors();

    double getPowerConsumed();

    Pair<Double, Double> getMaxPowerConsumed();

}
