package com.pmpavan;

import com.pmpavan.hotel.HotelBuilder;

import java.util.HashMap;

public class HotelManager {
    private HotelBuilder hotelBuilder;

    public HotelManager(int numberOfFloors,
                        int numberOfMainCorridors, HashMap<AppConstants.APPLIANCES, Integer> appliancesInMainCorridor,
                        int numberOfSubCorridors, HashMap<AppConstants.APPLIANCES, Integer> appliancesInSubCorridor) {
        hotelBuilder = new HotelBuilder();
        hotelBuilder.initHotelState(
                numberOfFloors,
                numberOfMainCorridors,
                appliancesInMainCorridor,
                numberOfSubCorridors,
                appliancesInSubCorridor);
    }


    String getCurrentHotelState() {
        return hotelBuilder != null ? hotelBuilder.toString() : "";
    }
}
