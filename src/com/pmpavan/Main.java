package com.pmpavan;

import java.util.HashMap;

import static com.pmpavan.AppConstants.*;

public class Main {

    private static int NUMBER_OF_FLOORS = 2;
    private static int NUMBER_OF_MAINCORRIDORS = 1;
    private static int NUMBER_OF_SUBCORRIDORS = 2;

    private static HotelManager manager;

    public static void main(String[] args) {

        initHotel();
        setSensorData(1, 0, false);
        initHotel();
        setSensorData(0, 0, true);
    }

    private static void initHotel() {
        HashMap<AppConstants.APPLIANCES, Integer> mainCorridorParams = new HashMap<>();
        mainCorridorParams.put(AppConstants.APPLIANCES.AC, NUMBER_OF_AC_IN_MAINCORRIDORS);
        mainCorridorParams.put(AppConstants.APPLIANCES.LIGHT, NUMBER_OF_LIGHT_IN_MAINCORRIDORS);
        HashMap<AppConstants.APPLIANCES, Integer> subCorridorParams = new HashMap<>();
        subCorridorParams.put(AppConstants.APPLIANCES.AC, NUMBER_OF_AC_IN_SUBCORRIDORS);
        subCorridorParams.put(AppConstants.APPLIANCES.LIGHT, NUMBER_OF_LIGHT_IN_SUBCORRIDORS);

        manager = new HotelManager(NUMBER_OF_FLOORS,
                NUMBER_OF_MAINCORRIDORS, mainCorridorParams,
                NUMBER_OF_SUBCORRIDORS, subCorridorParams);
        System.out.println(manager.getCurrentHotelState());

    }

    private static void setSensorData(int floorNumber, int corridorNumber, boolean isMainCorridor) {
        manager.setSensorData(floorNumber, corridorNumber, isMainCorridor);
        System.out.println("Updated Model " + manager.getCurrentHotelState());

    }

}
